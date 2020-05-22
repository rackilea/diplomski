private static int styleFromMessageType(int messageType) {
    switch (messageType) {
    case ERROR_MESSAGE:
        return JRootPane.ERROR_DIALOG;
    case QUESTION_MESSAGE:
        return JRootPane.QUESTION_DIALOG;
    case WARNING_MESSAGE:
        return JRootPane.WARNING_DIALOG;
    case INFORMATION_MESSAGE:
        return JRootPane.INFORMATION_DIALOG;
    case PLAIN_MESSAGE:
    default:
        return JRootPane.PLAIN_DIALOG;
    }
}