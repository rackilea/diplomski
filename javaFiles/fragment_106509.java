img = ImageIO.read(new File("sample.png"));
// This is the portion of the image we want to save...
BufferedImage cutout = img.getSubimage(150, 10, 100, 100);
// This is the area we want to paint over...
Rectangle bounds = new Rectangle(0, 0, img.getWidth(), img.getHeight());

Graphics2D g2d = img.createGraphics();
g2d.setColor(Color.BLACK);
// Save the current Composite so we can reset it...
Composite comp = g2d.getComposite();
// Apply the composite and fill the area...
g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
g2d.fill(area);
// Reset the composite 
g2d.setComposite(comp);
// Draw the part of the image we saved previously...
g2d.drawImage(cutout, 150, 10, this);
g2d.dispose();