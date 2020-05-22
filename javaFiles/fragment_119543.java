BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

Graphics g = image.getGraphics();

Path2D path = new Path2D.Double();
path.moveTo(20, 20);
path.lineTo(20, 30);
path.lineTo(40, 30);
path.closePath();

g.setClip(path);
g.drawImage(YourOrigioanlImage, 0, 0, null);