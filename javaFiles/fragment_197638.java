BufferedImage newImage = new BufferedImage(image.getWidth() + 2 * w, image.getHeight(), image.getType());

Graphics g = newImage.getGraphics();

g.setColor(Color.white);
g.fillRect(0, 0, image.getWidth() + 2 * w, image.getHeight());
g.drawImage(image, w, 0, null);
g.dispose();