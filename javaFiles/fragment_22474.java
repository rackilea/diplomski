public Flash(JComponent component) {
    this.component = component;
    float gHue = Color.RGBtoHSB(0, 1, 0, null)[0];
    float bHue = Color.RGBtoHSB(0, 0, 1, null)[0];
    for (int i = 0; i < N; i++) {
        clut.add(Color.getHSBColor(gHue + (i * (bHue - gHue) / N), 1, 1));
    }
    for (int i = 0; i < N; i++) {
        clut.add(Color.getHSBColor(bHue - (i * (bHue - gHue) / N), 1, 1));
    }
}