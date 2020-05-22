int x, y;
BufferedImage image;

public Sprite(BufferedImage image, int x, int y) throws IOException {
    this.image = image;
    this.x = x;
    this.y = y;
}

public BufferedImage getSprite() {
    return this.image;
}

public int getX() {
    return x;
}

public int getY() {
    return y;
}