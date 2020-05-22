public class NotificationPayloadFactory implements ArgumentFactory<NotificationPayload> {

    @Override
    public boolean accepts(Class<?> expectedType, Object value, StatementContext ctx) {
        return value instanceof NotificationPayload;
    }

    @Override
    public Argument build(Class<?> expectedType, NotificationPayload value, StatementContext ctx) {
        return value;
    }

}