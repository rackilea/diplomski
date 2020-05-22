private Color intToColor(int value) {
    int r = (value >>> 16) & 0xFF;
    int g = (value >>> 8) & 0xFF;
    int b = value & 0xFF;
    return Color.rgb(r,g,b);
}