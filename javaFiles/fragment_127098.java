private AtomicReference<BufferedImage> lastImageRef;

...
// in image reader
lastImageRef.set(theNewImage);

...
// in robotic arm
BufferedImage lastImage = lastImageRef.get();