class SoroushBotConsumer (private val endpoint: MyEndpoint, processor: Processor) : DefaultConsumer(endpoint, processor) {
    val objectMapper:ObjectMapper = ObjectMapper();
    override fun doStart() {
        val client = ClientBuilder.newBuilder().register(SseFeature::class.java).build()
        val target = client.target("MY_URL"))
        while(true){
            var e: EventInput?  target.request().get(EventInput::class.java)!!

            val inboundEvent = e.read()
            val exchange = endpoint.createExchange()
            exchange.getIn().body = objectMapper.readValue(inboundEvent.rawData,MessageModel::class.java)
            try {
                processor.process(exchange)
            } catch (e: Exception) {
                if (exchange.exception != null) {
                    exceptionHandler.handleException("Error processing exchange",exchange, exchange.exception)
                }
            }
        }
    }
}