public class MessageObserver extends ContentObserver {

    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int SMS_MESSAGE = 0;
    private static final int MMS_MESSAGE = 1;
    static {
        MATCHER.addURI("sms", "#", SMS_MESSAGE);
        MATCHER.addURI("mms", "#", MMS_MESSAGE);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        switch (MATCHER.match(uri)) {
            case SMS_MESSAGE:

                break;

            case MMS_MESSAGE:

                break;

            default:

        }
    }

    ...
}