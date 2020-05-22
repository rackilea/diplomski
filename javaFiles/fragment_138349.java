ImageWriteParam writeParam = writer.getDefaultWriteParam();
ImageTypeSpecifier typeSpecifier =
       ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);
IIOMetadata metadata = writer.getDefaultImageMetadata(typeSpecifier, writeParam);
if (metadata.isReadOnly() || !metadata.isStandardMetadataFormatSupported()) {
    continue;
}