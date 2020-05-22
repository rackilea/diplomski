public class MQMessage {
    public String event, link;

    @JsonRawValue
    public String details;
}


MQMessage message = new MQMessage();
message.event = "some event";
message.link = "Some link";
message.details = input;

String forMQ = new ObjectMapper().writeValueAsString(message);