public final class LogInfo {
    private static StringProperty logData = new SimpleStringProperty();
    // methods that set/format logData based on changes from your UI

    // provide public access to the property
    public static StringProperty logDataProperty() { return logData; }
    public static void setLogData(String data) { logData.set(data); }
    public static String getLogData() { return logData.get(); }
}