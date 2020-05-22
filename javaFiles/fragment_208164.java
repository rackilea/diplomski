File file = new File("gif1.gif");
ImageReader reader = ImageIO.getImageReadersBySuffix("GIF").next();
ImageInputStream in = ImageIO.createImageInputStream(file);
reader.setInput(in);

int numImages = reader.getNumImages(true); 
BufferedImage[] frames = new BufferedImage[pocetObrazku];

File fileOut = new File("k.gif");
fileOut.createNewFile();
ImageWriter iw = ImageIO.getImageWritersByFormatName("gif").next();

ImageOutputStream ios = ImageIO.createImageOutputStream(fileOut);
iw.setOutput(ios);
iw.prepareWriteSequence(null);

for (int i = 0; i < numImages ; i++) {
    BufferedImage image = reader.read(i);
    frames[i] = reader.read(i);

    IIOMetadata metadata = reader.getImageMetadata(i);    
    IIOImage ii = new IIOImage(image, null, metadata);      
    iw.writeToSequence(ii, (ImageWriteParam) null);    
}