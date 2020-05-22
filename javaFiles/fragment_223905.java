public class DPITest {
    public static void main(String[] args) throws IOException {
        File input = new File(args[0]);

        ImageInputStream stream = ImageIO.createImageInputStream(input);
        Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);

        if (readers.hasNext()) {
            ImageReader reader = readers.next();
            reader.setInput(stream);

            IIOMetadata metadata = reader.getImageMetadata(0);
            IIOMetadataNode standardTree = (IIOMetadataNode) metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);
            IIOMetadataNode dimension = (IIOMetadataNode) standardTree.getElementsByTagName("Dimension").item(0);
            float horizontalPixelSizeMM = getPixelSizeMM(dimension, "HorizontalPixelSize");
            float verticalPixelSizeMM = getPixelSizeMM(dimension, "VerticalPixelSize");

            // TODO: Convert pixelsPerMM to DPI left as an exercise to the reader.. ;-)  

            System.err.println("horizontalPixelSizeMM: " + horizontalPixelSizeMM);
            System.err.println("verticalPixelSizeMM: " + verticalPixelSizeMM);
        }
        else {
            System.err.printf("Could not read %s\n", input);
        }
    }

    private static float getPixelSizeMM(final IIOMetadataNode dimension, final String elementName) {
        // NOTE: The standard metadata format has defined dimension to pixels per millimeters, not DPI...
        NodeList pixelSizes = dimension.getElementsByTagName(elementName);
        IIOMetadataNode pixelSize = pixelSizes.getLength() > 0 ? (IIOMetadataNode) pixelSizes.item(0) : null;
        return pixelSize != null ? Float.parseFloat(pixelSize.getAttribute("value")) : -1;
    }
}