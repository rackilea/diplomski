public class NotificationMessagingTemplateCustom extends NotificationMessagingTemplate {

    public NotificationMessagingTemplateCustom(AmazonSNS amazonSns) {
        super(amazonSns);
    }

    @Override
    public void sendNotification(Object message, String subject) {

        MessageHeaders headersCustom = new MessageHeadersCustom();
        headersCustom.put(TopicMessageChannel.NOTIFICATION_SUBJECT_HEADER, subject);

        this.convertAndSend(getRequiredDefaultDestination(), message, headersCustom);
    }
}