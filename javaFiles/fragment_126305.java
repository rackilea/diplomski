public void drawSnowflake(Graphics g, int x, int y, int size, int level) {
    for (int a = 0; a < 360; a += 60) {
        double rad = a * Math.PI / 180;
        int x2 = (int) (x + Math.cos(rad) * size);
        int y2 = (int) (y + Math.sin(rad) * size);
        g.drawLine(x, y, x2, y2);
        if (level > 0) {
            drawSnowflake(g, x2, y2, size/3, level-1);
        }
    }
}