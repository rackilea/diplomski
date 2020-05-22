public static class UiPropBuilder {
    private XAxisProperties xAxisProperties = new XAxisProperties();
    private YAxisProperties yAxisProperties = new YAxisProperties();
    // ...
    public XAxisProperties xAxisProperties() { return xAxisProperties; }
    public YAxisProperties yAxisProperties() { return yAxisProperties; }

    public LineGraph build() {
        return new LineGraph(..., ..., ..., ...);
    }

    public class XAxisProperties {
        // ...
        public YAxisProperties yAxisProperties() { yAxisProperties; }
        public UiPropBuilder uiProperties() { return UiPropBuilder.this; }
        public LineGraph build() { return UiPropBuilder.this.build(); }
    }

    public class YAxisProperties {
        // ...
        public XAxisProperties xAxisProperties() { return xAxisProperties; }
        public UiPropBuilder uiProperties() { return UiPropBuilder.this; }
        public LineGraph build() { return UiPropBuilder.this.build(); }
    }
}