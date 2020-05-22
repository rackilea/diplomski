for (int i = 0; i < 12; i++) {
    float scale = (12 - i) / 12f;
    g2.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, scale * fade));
    g2.drawLine(cx + s, cy, cx + s * 2, cy);
    g2.rotate(-Math.PI / 6, cx, cy);
}