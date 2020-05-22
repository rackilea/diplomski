JTextArea myTextArea = new JTextArea("Some text") {
    @Override
    public FontMetrics getFontMetrics(Font font) {
        return new FontMetricsWrapper(super.getFontMetrics(font)) {
            @Override
            public int getHeight() {
                return 10;  // Gives line height in pixels
            }
        };
    }
};