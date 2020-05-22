ImageInputStream is = ImageIO.createImageInputStream(new File(pathToImage));
if (is == null || is.length() == 0){
  // handle error
}
Iterator<ImageReader> iterator = ImageIO.getImageReaders(is);
if (iterator == null || !iterator.hasNext()) {
  throw new IOException("Image file format not supported by ImageIO: " + pathToImage);
}
// We are just looking for the first reader compatible:
ImageReader reader = (ImageReader) iterator.next();
iterator = null;
reader.setInput(is);