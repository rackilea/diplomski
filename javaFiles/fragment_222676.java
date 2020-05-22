ImageInputStream stream = ImageIO.createImageInputStream(input);
ImageReader reader = ImageIO.getImageReaders(stream).next(); // TODO: Test hasNext()
reader.setInput(stream);

int width = reader.getWidth(0);
int height = reader.getHeight(0);
ImageTypeSpecifier spec = reader.getImageTypes(0).next(); // TODO: Test hasNext(); 

BufferedImage image = MappedImageFactory.createCompatibleMappedImage(width, height, spec)

ImageReadParam param = reader.getDefaultReadParam();
param.setDestination(image);

image = reader.read(0, param); // Will return same image as created above

// ...process image as needed...