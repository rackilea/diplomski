// Get subimage "normal way"
BufferedImage subimage = image.getSubimage(25, 25, 50, 50);

// Create new empty image of same type
BufferedImage subThree = new BufferedImage(50, 50, image.getType());

// Draw the subimage onto the new, empty copy
Graphics2D g = subThree.createGraphics();
try {
    g.drawImage(subimage, 0, 0, null);
}
finally {
    g.dispose();
}