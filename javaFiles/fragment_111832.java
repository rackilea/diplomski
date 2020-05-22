public void spawn(JFrame frame, BufferedImage world, int x, int y) throws IOException, InterruptedException {
    int orig_x = x;
    for (int sprite_y = 0; sprite_y < this.image.getHeight(); sprite_y++) {
        if (sprite_y == this.image.getHeight() / 2) {
            Thread.sleep(100);
        }