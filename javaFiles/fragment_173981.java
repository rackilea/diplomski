val ssc = new StreamingContext(sparkConf, Seconds(2))
val directKafkaStream = KafkaUtils.createDirectStream[
     [key class], [value class], [key decoder class], [value decoder class] ](
     streamingContext, [map of Kafka parameters], [set of topics to consume])
val topicFirst = directKafkaStream.filter (_._1 == "topic1")
val topic2 = directKafkaStream.filter (_._1 == "topic2")

topicFirst.foreachRDD (rdd => {
    // do some processing with data collected from specified time window
});