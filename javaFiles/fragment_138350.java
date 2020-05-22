int DPI = 72 * scaling/100;
double dotsPerMilli = 1.0 * DPI / 10 / 2.54;
double checkDots = 1.0 * 144 / 10 / 2.54;
System.out.println("Dots per inch: " + DPI + ", DotsPerMilli: " + dotsPerMilli + ",
    CheckDots = " + checkDots);
IIOMetadataNode root = new IIOMetadataNode("javax_imageio_1.0");
IIOMetadataNode horiz = new IIOMetadataNode("HorizontalPixelSize");
horiz.setAttribute("value", Double.toString(dotsPerMilli));
IIOMetadataNode vert = new IIOMetadataNode("VerticalPixelSize");
vert.setAttribute("value", Double.toString(dotsPerMilli));
IIOMetadataNode dim = new IIOMetadataNode("Dimension");
dim.appendChild(horiz);
dim.appendChild(vert);
root.appendChild(dim);
metadata.mergeTree("javax_imageio_1.0", root);