public class ICCTest {
    public static void main(String[] args) throws IOException {
        // Fist let's assume this isn't already in sRGB (it is...)
        BufferedImage inputImage = new BufferedImage(10, 10, BufferedImage.TYPE_3BYTE_BGR);

        // Conversion similar to yours
        ColorSpace sRGB = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        WritableRaster raster = new ColorConvertOp(inputImage.getColorModel().getColorSpace(), sRGB, null)
            .filter(inputImage.getRaster(), null);

        ComponentColorModel cm = new ComponentColorModel(sRGB, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        BufferedImage converted = new BufferedImage(cm, raster, cm.isAlphaPremultiplied(), null);

        // Just for comparison    
        ImageIO.write(converted, "JPEG", new File("converted.jpg"));

        // Write image with forced ICC profile
        ImageWriter writer = ImageIO.getImageWritersByFormatName("JPEG").next();
        try (ImageOutputStream out = ImageIO.createImageOutputStream(new File("converted_icc.jpg"))) {
            writer.setOutput(out);

            ImageWriteParam param = writer.getDefaultWriteParam();
            IIOMetadata metadata = writer.getDefaultImageMetadata(ImageTypeSpecifier.createFromRenderedImage(converted2), param);
            metadata.mergeTree("javax_imageio_jpeg_image_1.0", createICCTree((ICC_ColorSpace) sRGB));

            writer.write(null, new IIOImage(converted, null, metadata), param);
        }
        writer.dispose();
    }

    // Create a minimal IIOMetadata tree, containing an ICC profile
    private static IIOMetadataNode createICCTree(ColorSpace cs) {
        IIOMetadataNode root = new IIOMetadataNode("javax_imageio_jpeg_image_1.0");

        IIOMetadataNode jpegVariety = new IIOMetadataNode("JPEGvariety");
        root.appendChild(jpegVariety);
        root.appendChild(new IIOMetadataNode("markerSequence")); // Must be present, even if empty...

        IIOMetadataNode app0JFIF = new IIOMetadataNode("app0JFIF");
        jpegVariety.appendChild(app0JFIF);

        IIOMetadataNode icc = new IIOMetadataNode("app2ICC");
        app0JFIF.appendChild(icc);

        icc.setUserObject(cs.getProfile());

        return root;
    }
}