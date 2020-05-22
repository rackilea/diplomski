public void saveComponentAsTiff(Component c, String filename, boolean subcomp) throws IOException {
    saveComponentTiff(c, "tiff", filename, subcomp);
}

public void saveComponent(Component c, String format, String filename, boolean subcomp) throws IOException {
    // Create a renderable image with the same width and height as the component
    BufferedImage image = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);

    if(subcomp) {
        // Render the component and all its sub components
        c.paintAll(image.getGraphics());
    }
    else {
        // Render the component and ignoring its sub components
        c.paint(image.getGraphics());
    }

    // Save the image out to file
    ImageIO.write(image, format, new File(filename));
}