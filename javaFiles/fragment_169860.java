// Draw image as if the previous image was rotated around its center
// Image starts out being 1x1 with origin in lower left
// Move origin to center of image
AffineTransform A = AffineTransform.getTranslateInstance(-0.5, -0.5);
// Stretch it to its dimensions
AffineTransform B = AffineTransform.getScaleInstance(image.getWidth(), image.getHeight());
// Rotate it
AffineTransform C = AffineTransform.getRotateInstance(rotate);
// Move it to have the same center as above
AffineTransform D = AffineTransform.getTranslateInstance(x + image.getWidth()/2, y + image.getHeight()/2);
// Concatenate
AffineTransform M = (AffineTransform) A.clone();
M.preConcatenate(B);
M.preConcatenate(C);
M.preConcatenate(D);
//Draw
contentByte.addImage(image, M);