Image src = ImageIO.read(new File("duke.jpg"));

int x = 10, y = 20, w = 40, h = 50;

BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);

ImageIO.write(dst, "png", new File("duke_cropped.png"));