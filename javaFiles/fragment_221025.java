// This should not be done in the draw method, but rather when
// the frame is created. You should also make a new buffer image when
// the frame is resized. `frameWidth` and `frameHeight` are the
// frame's dimensions.
BufferedImage bufferImage = new BufferedImage(frameWidth, frameHeight,
            BufferedImage.TYPE_INT_ARGB);
Graphics2D bufferGraphics = bufferImage.createGraphics();


// In your draw method, do the following steps:

// 1. Clear the buffer:
bufferGraphics.clearRect(0, 0, width, height);

// 2. Draw things to bufferGraphics...

// 3. Copy the buffer:
g2.drawImage(bufferImage, null, 0, 0);

// When you want to save your image presented in the frame, call the following:
ImageIO.write(bufferImage, "png", new File("frameImage.png"));