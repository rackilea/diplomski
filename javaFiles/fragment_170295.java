List<ImageIcon> images = new ArrayList<ImageIcon>();// Array list

for (int fileInList = 0; fileInList < files.length; fileInList++) {
 if (files[fileInList].isFile()) {
   Image baseImage = ImageIO.read(files[fileInList]);
   BufferedImage scaledImage = new BufferedImage(85, 100, BufferedImage.TYPE_INT_RGB);
   Graphics2D g2d = (Graphics2D)scaledImage.createGraphics();
   g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY));
   g2d.drawImage(baseImage, 0, 0, 85, 100, null);
   images.add(0, new ImageIcon(scaledImage));
 }
}