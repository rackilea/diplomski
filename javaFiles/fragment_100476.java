public static void main(String args[]) throws IOException {
    BufferedImage img = null;
    File f = null;
    File m = null;
    int c = 0;
    try {
        f = new File("C:\\Users\\Lance Dean\\Desktop\\Java\\Sample.jpg");
        img = ImageIO.read(f);
    } catch (IOException e) {
        System.out.println(e);
    }
    int width = img.getWidth();
    int height = img.getHeight();
    for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            int p = img.getRGB(i, j);
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            c++;
            System.out.println(c);
            int a = 4 * (int) (Math.floor(255 / 4));
            int x = 4 * (int) (Math.floor((double) (r / 4)));
            int y = 4 * (int) (Math.floor((double) (g / 4)));
            int z = 4 * (int) (Math.floor((double) (b / 4)));
            p = (a << 24) | (x << 16) | (y << 8) | z;
            img.setRGB(i, j, p);
        }
    }
    try {
        m = new File("C:\\Users\\Lance Dean\\Desktop\\Java\\End.jpg");
        if (!m.canRead()) {
            m.setReadable(true);
        }
        ImageIO.write(img, "jpg", m);
    } catch (IOException e) {
        System.out.println(e);
    }
}