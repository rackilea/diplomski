BufferedImage buffer = ImageIO.read(...);
AffineTransform tx = new AffineTransform();
tx.translate(buffer.getHeight() / 2, buffer.getWidth() / 2);
tx.shear(0.3, 0);
tx.translate(-buffer.getWidth() / 2, -buffer.getHeight() / 2);

AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

BufferedImage newImage = new BufferedImage(buffer.getHeight(), buffer.getWidth(), BufferedImage.TYPE_INT_ARGB);
op.filter(buffer, newImage);

JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(newImage)));