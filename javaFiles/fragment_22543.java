import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class WrappedMessage implements IMessage {
    private final IMessage message;

    public WrappedMessage(IMessage message) {
        this.message = message;
    }

    @Override
    public int hashCode() { // TODO add your own implementation
        return 4; // chosen by fair dice roll.
                  // guaranteed to be random.
    }

    @Override
    public boolean equals(Object obj) { // TODO add your own implementation
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    // Delegate all other methods:

    @Override
    public IMessage createCopy() {
        // this method is special as it returns an IMessage,
        // make sure to give back our wrapper instead
        return new WrappedMessage(message.createCopy());
    }

    @Override
    public byte[] getBody() {
        return message.getBody();
    }

    @Override
    public void setBody(byte[] body) {
        message.setBody(body);
    }

    @Override
    public String getContentType() {
        return message.getContentType();
    }

    @Override
    public void setContentType(String contentType) {
        message.setContentType(contentType);
    }

    @Override
    public String getCorrelationId() {
        return message.getCorrelationId();
    }

    @Override
    public void setCorrelationId(String correlationId) {
        message.setCorrelationId(correlationId);
    }

    @Override
    public String getDeadLetterSource() {
        return message.getDeadLetterSource();
    }

    @Override
    public long getDeliveryCount() {
        return message.getDeliveryCount();
    }

    @Override
    public Instant getEnqueuedTimeUtc() {
        return message.getEnqueuedTimeUtc();
    }

    @Override
    public Instant getExpiresAtUtc() {
        return message.getExpiresAtUtc();
    }

    @Override
    public String getLabel() {
        return message.getLabel();
    }

    @Override
    public void setLabel(String label) {
        message.setLabel(label);
    }

    @Override
    public UUID getLockToken() {
        return message.getLockToken();
    }

    @Override
    public Instant getLockedUntilUtc() {
        return message.getLockedUntilUtc();
    }

    @Override
    public void setLockedUntilUtc(Instant lockedUntilUtc) {
        message.setLockedUntilUtc(lockedUntilUtc);
    }

    @Override
    public MessageBody getMessageBody() {
        return message.getMessageBody();
    }

    @Override
    public void setMessageBody(MessageBody body) {
        message.setMessageBody(body);
    }

    @Override
    public String getMessageId() {
        return message.getMessageId();
    }

    @Override
    public void setMessageId(String messageId) {
        message.setMessageId(messageId);
    }

    @Override
    public String getPartitionKey() {
        return message.getPartitionKey();
    }

    @Override
    public void setPartitionKey(String partitionKey) {
        message.setPartitionKey(partitionKey);
    }

    @Override
    public Map<String, Object> getProperties() {
        return message.getProperties();
    }

    @Override
    public void setProperties(Map<String, Object> properties) {
        message.setProperties(properties);
    }

    @Override
    public String getReplyTo() {
        return message.getReplyTo();
    }

    @Override
    public void setReplyTo(String replyTo) {
        message.setReplyTo(replyTo);
    }

    @Override
    public String getReplyToSessionId() {
        return message.getReplyToSessionId();
    }

    @Override
    public void setReplyToSessionId(String replyToSessionId) {
        message.setReplyToSessionId(replyToSessionId);
    }

    @Override
    public Instant getScheduledEnqueueTimeUtc() {
        return message.getScheduledEnqueueTimeUtc();
    }

    @Override
    public void setScheduledEnqueueTimeUtc(Instant scheduledEnqueueTimeUtc) {
        message.setScheduledEnqueueTimeUtc(scheduledEnqueueTimeUtc);
    }

    @Override
    public Instant getScheduledEnqueuedTimeUtc() {
        return message.getScheduledEnqueuedTimeUtc();
    }

    @Override
    public void setScheduledEnqueuedTimeUtc(Instant scheduledEnqueueTimeUtc) {
        message.setScheduledEnqueuedTimeUtc(scheduledEnqueueTimeUtc);
    }

    @Override
    public long getSequenceNumber() {
        return message.getSequenceNumber();
    }

    @Override
    public String getSessionId() {
        return message.getSessionId();
    }

    @Override
    public void setSessionId(String sessionId) {
        message.setSessionId(sessionId);
    }

    @Override
    public Duration getTimeToLive() {
        return message.getTimeToLive();
    }

    @Override
    public void setTimeToLive(Duration timeToLive) {
        message.setTimeToLive(timeToLive);
    }

    @Override
    public String getTo() {
        return message.getTo();
    }

    @Override
    public void setTo(String to) {
        message.setTo(to);
    }

    @Override
    public String getViaPartitionKey() {
        return message.getViaPartitionKey();
    }

    @Override
    public void setViaPartitionKey(String partitionKey) {
        message.setViaPartitionKey(partitionKey);
    }
}