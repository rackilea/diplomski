// Alternate, using IndexColorModel, if your input isn't in linear gray color space
int[] cmap = new int[256]; // TODO: Add ARGB packed colors here...
IndexColorModel icm = new IndexColorModel(8, 256, cmap, 0, false, -1, DataBuffer.TYPE_BYTE);

// As 1
BufferedImage image3 = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_INDEXED, icm);
image3.getRaster().setDataElements(0, 0, w, h, imageBytes);
System.out.println("image3: " + image3);

// As 2
BufferedImage image4 = new BufferedImage(icm, raster, cm.isAlphaPremultiplied(), null);

System.out.println("image4: " + image4);