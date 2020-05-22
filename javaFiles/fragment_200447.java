public class Size {
    private final int sampleFactor;

    private Size(int sampleFactor) {
        this.sampleFactor = sampleFactor;
    }

    public static Size thumbnail() {
        return new Size(THUMBNAIL_FACTOR);
    }

    public static Size real() {
        return new Size(REAL_FACTOR);
    }

    public static Size custom(int factor) {
        return new Size(factor);
    }
}