val broadcastValue = ssc.sparkContext.broadcast(JsonMapper)

val kafkaParams = Map("metadata.broker.list" -> Properties.kafka_brokers, "auto.offset.reset" -> Properties.kafka_auto_reset_offset)

//
// BITSTAMP
//
val bitstampTopic = Set("bitstamp_trades")
val bitstampStream = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, bitstampTopic)
val bitstampTradeStream = bitstampStream.map(_._2).map { trade =>
  broadcastValue.value.registerModule(new DefaultScalaModule with RequiredPropertiesSchemaModule)
  val jsonNode = broadcastValue.value.readTree(trade)
  Trade(
    "BITSTAMP",
    "BTC_USD",
    if(jsonNode.get("type").asInt() == 1) "SELL" else "BUY",
    DateFormatter.format(new Date(jsonNode.get("timestamp").asLong() * 1000)),
    new Date(jsonNode.get("timestamp").asLong() * 1000),
    jsonNode.get("amount").asDouble(),
    jsonNode.get("price").asDouble()
  )
}