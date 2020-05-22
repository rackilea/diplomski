private Color[] colors;
private int[][][] coordinates;
BoringTriangle() {
    Random nmb = new Random();
    colors = new Color[500];
    coordinates = new int[500][2][];
    for (int i = 0; i < 500; i++) {
        colors[i] = new Color(nmb.nextInt(200) + 1, nmb.nextInt(200) + 1, nmb.nextInt(200) + 1);
        coordinates[i][0] = new int[] {nmb.nextInt(500) + 1, nmb.nextInt(500) + 1, nmb.nextInt(500) + 1};
        coordinates[i][1] = new int[] {nmb.nextInt(500) + 1, nmb.nextInt(500) + 1, nmb.nextInt(500) + 1};
    }
}

public void paint(Graphics g) {
    for(int i = 0; i < colors.length; i++) {
        g.setColor(colors[i]);
        g.fillPolygon(coordinates[i][0], coordinates[i][1], 3);
    }
}