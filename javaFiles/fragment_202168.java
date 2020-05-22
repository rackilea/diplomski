RenderedImage renderedImage[], page;
File tiffFile = new File("C:\\Users\\username\\Desktop\\file.tif");

SeekableStream seekableStream = new FileSeekableStream(tiffFile);
ImageDecoder imageDecoder = ImageCodec.createImageDecoder("tiff",seekableStream, null);
renderedImage = new RenderedImage[imageDecoder.getNumPages()];

int tifPageCount = 0;
for (int k = 0; k < imageDecoder.getNumPages(); k++) {
    renderedImage[k] = imageDecoder.decodeAsRenderedImage(k);
    tifPageCount++;
}