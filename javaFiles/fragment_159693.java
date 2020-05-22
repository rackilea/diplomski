@JsonSubTypes({
  @JsonSubTypes.Type(value = SMSNotification.class, name = "SMSNotification"),
  @JsonSubTypes.Type(value = EmailNotification.class, name = "EmailNotification"),
})
public class Notification {
    ....