public class LineBuilder {
    private StringBuilder builder;
    private static final String BR_TAG = "<br/>";

    public LineBuilder() {
        builder = new StringBuilder();
    }

    public LineBuilder addLine(String text) {
        builder.append(text).append(BR_TAG);
        return this;
    }

    public String build() {
        return builder.toString();
    }
}