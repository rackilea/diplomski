BufferedImage image = ImageIo.read(new File("imageName"));
ColorSpace colorSpace = image.getColorModel().getColorSpace();
int type = colorSpace.getType();
if (type = ColorSpace.CS_GRAY ){
    //...
}