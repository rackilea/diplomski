try
{

    ImageOutputStream  ios =  ImageIO.createImageOutputStream(var7);
    Iterator<ImageWriter> iter = ImageIO.getImageWritersByFormatName("jpeg");
    ImageWriter writer = iter.next();
    ImageWriteParam iwp = writer.getDefaultWriteParam();
    iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    iwp.setCompressionQuality(0.85f);
    writer.setOutput(ios);
    writer.write(null, new IIOImage(var6,null,null),iwp);
    writer.dispose();

    //ImageIO.write(var6, "jpg", var7);
}