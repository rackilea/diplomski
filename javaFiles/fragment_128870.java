import org.w3c.dom.Element;

ImageWriter     writer = ImageIO.getImageWritersByFormatName("jpeg").next();
ImageWriteParam param    = writer.getDefaultWriteParam();

param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
param.setCompressionQuality(0.95f);

IIOMetadata metadata = writer.getDefaultImageMetadata(ImageTypeSpecifier.createFromRenderedImage(image), param);
Element     tree     = (Element)metadata.getAsTree("javax_imageio_jpeg_image_1.0");
Element     jfif     = (Element)tree.getElementsByTagName("app0JFIF").item(0);
jfif.setAttribute("Xdensity", Integer.toString(350));
jfif.setAttribute("Ydensity", Integer.toString(350));
jfif.setAttribute("resUnits", "1"); // In pixels-per-inch units
metadata.mergeTree("javax_imageio_jpeg_image_1.0", tree);

try (FileImageOutputStream output = new FileImageOutputStream(new File(filename))) {
    writer.setOutput(output);
    IIOImage iioImage = new IIOImage(image, null, metadata);
    writer.write(metadata, iioImage, param);
    writer.dispose();
}