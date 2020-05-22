for (int i = 0; i < N; i++) {
    g2d.setColor(…);
    int d = (i + 1) * S + random.nextInt(S / 2);
    int r = d / 2;
    g2d.drawArc(x - r, y - r, d, d, 0, 360);
}