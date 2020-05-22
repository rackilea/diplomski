AreaAveragingScaleFilter scaleFilter =
    new AreaAveragingScaleFilter(
                Math.round(originalWidth / factorX),
                Math.round(originalHeight / factorY));
ImageProducer producer = new FilteredImageSource(original.getSource(), scaleFilter);
ImageGenerator generator = new ImageGenerator();
producer.startProduction(generator);
BufferedImage scaled = generator.getImage();

for(int x = 0; x < scaled.getWidth(); x++) {
    for(int y = 0; y < scaled.getHeight(); y++) {
        int rgb = scaled.getRGB(x, y);
        int alpha = (rgb >> 24) & 0xff;
        if(alpha != 255) {
            scaled.setRGB(x, y,-1); //set white
        }
    }
}


JPEGImageWriteParam param = new JPEGImageWriteParam(null);
param.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
param.setCompressionQuality((float) 0.85);
java.util.Iterator<ImageWriter> it = ImageIO.getImageWritersBySuffix("jpg");
ImageWriter writer = it.next();
dest.getParentFile().mkdirs();
writer.setOutput(new FileImageOutputStream(dest));
writer.write(null, new IIOImage(scaled, null, null), param);
writer.dispose();