public enum Color {
    r(0xff0000), g(0x00ff00), b(0x0000ff);
    Color(int rgb) {
        this.rgb=rgb;
    }
    final int rgb;
}