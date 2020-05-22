public void drawRotated(BufferedImage img,double rotationRequired,int x,int y,Canvas canvas, Graphics g, Observer observer) {
        //double rotationRequired = Math.toRadians(degrees);
        double locationX = img.getWidth() / 2;
        double locationY = img.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        BufferedImage rotatedImage = op.filter(img, null); // my edit here

        // Drawing the rotated image at the required drawing locations
        g.drawImage(rotatedImage , x, y, null);
    }