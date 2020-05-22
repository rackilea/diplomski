BufferedImage frame = new BufferedImage(imageAttr.get("imageWidth"), imageAttr.get("imageHeight"), BufferedImage.TYPE_INT_ARGB);

Graphics2D g2d = frame.createGraphics();
g2d.drawImage(image, imageAttr.get("imageLeftPosition"), imageAttr.get("imageTopPosition"), null);
g2d.dispose();

frame = mirror(frame);
ImageIO.write(frame, "png", new File("img" + i + ".png"));
images.add(frame);