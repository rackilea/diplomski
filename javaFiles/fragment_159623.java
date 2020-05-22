ImageWriter writer  = ImageIO.getImageWritersByFormatName("jpg").next();
ImageWriteParam param = writer.getDefaultWriteParam();

param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
param.setCompressionQuality(quality);

writer.setOutput(new FileImageOutputStream(
    new File(String.format("screen.%.1f.jpg", quality))));
writer.write(null, new IIOImage(image, null, null), param);
writer.dispose();