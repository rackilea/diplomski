InputStream is = new BufferedInputStream(new ByteArrayInputStream(imageData));
Image src = null;
Iterator<ImageReader> it = ImageIO.getImageReadersByMIMEType("image/jpeg");
ImageReader reader = it.next();
ImageInputStream iis = ImageIO.createImageInputStream(is);
reader.setInput(iis, false, false);
src = reader.read(0);
IIOMetadata imageMetadata = reader.getImageMetadata(0);