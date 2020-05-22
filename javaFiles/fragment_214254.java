BufferedImage original; //Instatiate with desired image.
BufferedImage transformed:  //Used to store transformed image.
AffineTransform at; //Transformations needed.

AffineTransformOp affineTransformOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
affineTransformOp.filter(original, transformed );