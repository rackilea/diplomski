enum Color {
    RED(255,0,0),
    GREEN(0,255,0),
    BLUE(0,0,255);

    int[] rgb;

    Color(int... rgb) {
        this.rgb = rgb;
    }
}