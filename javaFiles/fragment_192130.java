//Update affine transformation
at = AffineTransform.getTranslateInstance(x, y);
at = AffineTransform.getScaleInstance(zoom, zoom);

at.translate(x, y);
at.scale(zoom, zoom);      

//Create affine transformation
AffineTransformOp op = new AffineTransformOp(at,  AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

//Apply transformation
BufferedImage img2 = op.filter(img, null);

//Draw image
g2d.drawImage(img2, 0, 0, this);