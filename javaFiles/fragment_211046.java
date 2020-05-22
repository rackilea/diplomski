// Get subimage "normal way"
BufferedImage subimage = image.getSubimage(25, 25, 50, 50);

// Create empty compatible image
BufferedImage subTwo = new BufferedImage(image.getColorModel(), image.getRaster().createCompatibleWritableRaster(50, 50), image.isAlphaPremultiplied(), null);

// Copy data into the new, empty image
subimage.copyData(subTwo.getRaster());