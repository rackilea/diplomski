BufferedImage original = ... // dimensions width x height, black on transparent

// create red image
BufferedImage redVersion = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
Graphics2D g = (Graphics2D) redVersion.getGraphics();
g.setColor(Color.red);
g.fillRect(0, 0, width, height);

// paint original with composite
g.setComposite(AlphaComposite.DstIn);
g.drawImage(image, 0, 0, width, height, 0, 0, width, height, null);

// redVersion is now a red version of original