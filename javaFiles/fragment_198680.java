public final class DefaultListModelUtils {

    private DefaultListModelUtils() {}

    public static final void addElement(DefaultListModel<String> defaultListModel, LogItem logItem) {
        defaultListModel.addElement(getLogItemAsString(logItem));
    }

    private static String getLogItemAsString(LogItem logItem) {
        return "[" + logItem.getTimestamp() + "] " + logItem.getEvent();
    }
}