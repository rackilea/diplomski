private void createEmptyImage() throws MagickException{
    ImageInfo newImageiInfo=new ImageInfo();
    newImageiInfo.setFileName("src\\main\\resources\\test.jpg");
    newImageiInfo.setSize("512x512");
    newImageiInfo.setUnits(ResolutionType.PixelsPerInchResolution);
    newImageiInfo.setColorspace(ColorspaceType.RGBColorspace);
    newImageiInfo.setBorderColor(PixelPacket.queryColorDatabase("red"));
    newImageiInfo.setDepth(8);

    MagickImage addTextImage = new MagickImage();
    addTextImage.allocateImage(newImageiInfo);
    addTextImage.setYResolution(480);
    addTextImage.setXResolution(640);
    addTextImage.writeImage(newImageiInfo);


    DrawInfo aInfo = new DrawInfo(newImageiInfo);

    aInfo.setFill(PixelPacket.queryColorDatabase("green"));
    aInfo.setUnderColor(PixelPacket.queryColorDatabase("yellow"));
    aInfo.setOpacity(0);
    aInfo.setPointsize(36);
    aInfo.setFont("Arial");
    aInfo.setTextAntialias(true);
    aInfo.setText("JMagick Tutorial");
    aInfo.setGeometry("+50+50");

    addTextImage.annotateImage(aInfo);
    addTextImage.setFileName("src\\main\\resources\\test-result.jpg");
    addTextImage.writeImage(newImageiInfo);
}