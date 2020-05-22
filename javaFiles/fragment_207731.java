BufferedImage fullImage = ImageIO.read(new URL("textures.png"));

for (int x = 0; x < 1280; x += 1) {
    for (int y = 0; y < 1280; y += 1) {
        textures[x][y] = fullImage.getSubimage(x*64, y*64, 64, 64);
    }
}