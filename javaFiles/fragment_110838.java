Graphics2D g2 = im.createGraphics();

g2.setColor(Color.BLACK);
g2.drawString("10", 2, 10);

ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(im, "png", baos);
byte[] b = baos.toByteArray();