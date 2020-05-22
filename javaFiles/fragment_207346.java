public static class DriverSnapshotHandler {

    private final FormatterService formatter;

    //used in production code
    public DriverSnapshotHandler() {
        this(FormatterService.getInstance());
    }

    //used for tests
    DriverSnapshotHandler(FormatterService formatter) {
        this.formatter = formatter;
    }

    public String getImageURL() {
        return formatter.formatTachoIcon();
    }
}