IIOImage outputImage = new IIOImage(bufferedImage, null, null);

ImageWriter writer = ImageIO.getImageWritersByFormatName("jpeg").next();        
writer.setOutput(new FileImageOutputStream(outFile));
ImageWriteParam writeParam = writer.getDefaultWriteParam();
writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
writeParam.setCompressionQuality(.75f); // float between 0 and 1, 1 for max quality.
writer.write( null, outputImage, writeParam);