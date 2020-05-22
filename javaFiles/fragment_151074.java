public static void main(String[] args) throws IOException {
BufferedImage old = ImageIO.read(new File("download.gif"));
int w = old.getWidth();
int h = old.getHeight();

BufferedImage img = new BufferedImage(
        w, h, BufferedImage.TYPE_INT_ARGB);

Graphics2D g2d = img.createGraphics();
g2d.drawImage(old, 0, 0, null);
g2d.setColor(Color.red);
g2d.drawRect(10, 10, 100, 100);
g2d.dispose();

    ImageIO.write(img, "gif", new File("out.gif"));  

    }