ByteArrayOutputStream baos = new ByteArrayOutputStream(37628);
ImageOutputStream  ios =  ImageIO.createImageOutputStream(baos);

//Instead of baos if I pass a FileOutputStream to the above function. It writes non zero
//bytes to the output file

TIFFImageWriterSpi tiffspi = new TIFFImageWriterSpi();
ImageWriter writer = tiffspi.createWriterInstance();
RenderedImage renderedImage = PlanarImage.wrapRenderedImage(src);
writer.setOutput(ios);
writer.write(image);
writer.write(null,new IIOImage(image, null, null), param);

//Create a ByteArrayInputStream to read that ByteArrayOutputStream and read it from ImageIO

ByteArrayInputStream bai = new ByteArrayInputStream(baos.toByteArray());
RenderedImage out = ImageIO.read(bai);
int size = bos.toByteArray().length;

System.out.println(""+ size);

return bos.toByteArray