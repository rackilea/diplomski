public BufferedImage[] getAllSprites() {
    BufferedImage[] sprites = new BufferedImage[frames];
    int y = 0;
    for (int i = 0; i < frames; i++) {
        x = i * frameWidth;
        currentSprite = sheet.getSprite(x,y,frameHeight,frameWidth);
        sprites.add(currentSprite);
    }
    return sprites;

}