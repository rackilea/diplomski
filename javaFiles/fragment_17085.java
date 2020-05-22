BufferedImage img1 = ImageIO.read(new File("..."));
BufferedImage img2 = ImageIO.read(new File("..."));

int width = img1.getWidth();
int height = img1.getHeight();

BufferedImage temp = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
Graphics2D g = temp.createGraphics();
g.drawImage(img1, 0, 0, null);

for (int row = 0; row < height; row++) {
    for (int col = 0; col < width; col++) {
        int result = img1.getRGB(col, row);
        int result1 = img2.getRGB(col, row);
        if (result != result1) {
                g.setColor(Color.red);
                g.setStroke(new BasicStroke(2.0F));
                g.drawRect(col - 5, row - 12, 35, 35);
        }
    }
}
g.dispose();

JOptionPane.showMessageDialog(null, new ImageIcon(temp));