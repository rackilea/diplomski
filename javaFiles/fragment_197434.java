ImageReader reader = ...;

IIOMetadata metadata = reader.getImageMetadata(0); // 0, first image
IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);
IIOMetadataNode compression = (IIOMetadataNode) root.getElementsByTagName("CompressionTypeName").item(0);
String compressionName = compression.getAttribute("value");

System.out.printf("Compression: %s", compressionName);