static AffineTransform getWatermarkTransform(List<String> watermarkLines, int x) {
    return AffineTransform.getTranslateInstance(6 + 15*x, 6);
}

static Rectangle getWatermarkRect() {
    return new Rectangle(65, 50);
}

static List<String> getWatermarkLines() {
    return Arrays.asList("Test line 1", "Test line 2");
}