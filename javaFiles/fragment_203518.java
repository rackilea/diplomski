class CustomColor {

    private static final Random RANDOM = new Random();
    private static final int DARKNESS_LEVEL_COUNT = 5;
    private static final float[] DARKNESS_LEVELS = new float[] {0.9f, 0.7f, 0.5f, 0.3f, 0.1f};
    private static final float SATURATION = 1f;

    private float hue;
    private int darknessLevel;

    public CustomColor(float hue) {
        this.hue = hue;
        darknessLevel = RANDOM.nextInt(DARKNESS_LEVEL_COUNT - 1); // I'm guessing you don't create the darkest blocks
    }

    public int getColor() {
        float[] hsv = new float[] {hue, SATURATION, DARKNESS_LEVELS[darknessLevel]};
        return Color.HSVToColor(hsv);
    }

    public boolean equals(CustomColor other) {
        return (hue == other.hue) && (darknessLevel == other.darknessLevel);
    }

    public boolean darken() {
        darknessLevel++;
        return darknessLevel == DARKNESS_LEVEL_COUNT - 1; // are we at max darkness?
    }
}