int xOffset = 0;
for (int row = 0; row < 8; row++) {
    int y = startY + (row * (height + spacing));
    if (row % 2 == 0) {
        xOffset = width / 2;
    } else {
        xOffset = 0;
    }
    for (int col = 0; col < 8; col++) {
        int x = xOffset + (startX + (col * (width + spacing)));
        System.out.println(x + "x" + y);
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}