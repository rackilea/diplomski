public class WsOrderReply {

        private final String topic;
        private final Message message;
        private final Long timestamp;
        ObjectMapper mapper = new ObjectMapper();

        @JsonCreator
        public WsOrderReply(
                @JsonProperty("topic") String topic,
                @JsonProperty("message") String messageString,
                @JsonProperty("timestamp") Long timestamp) {
            this.topic = topic;
            this.message = mapper.readValue(messageString, Message.class);;
            this.timestamp = timestamp;
        }
    }