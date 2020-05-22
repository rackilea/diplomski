File inFile = ...;
File outFile = ...; // Feel free to use ".jif" as extension

    BufferedImage image = ImageIO.read(inFile);

    ImageWriter jpegWriter = ImageIO.getImageWritersByFormatName("JPEG").next(); // Should be a least one

    // To write comments, we need to add it to the metadata
    ImageWriteParam param = jpegWriter.getDefaultWriteParam();
    IIOMetadata metadata = jpegWriter.getDefaultImageMetadata(ImageTypeSpecifier.createFromRenderedImage(image), param);
    IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree("javax_imageio_jpeg_image_1.0");
    IIOMetadataNode markerSequence = (IIOMetadataNode) root.getElementsByTagName("markerSequence").item(0); // Should be only one

    // Insert a "COM" marker, with our comment
    IIOMetadataNode com = new IIOMetadataNode("com");
    com.setAttribute("comment", "Hello JFIF!");
    markerSequence.appendChild(com);

    // Merge edited metadata 
    metadata.mergeTree("javax_imageio_jpeg_image_1.0", root);

    ImageOutputStream output = ImageIO.createImageOutputStream(outFile);
    try {
        jpegWriter.setOutput(output);

        // Write image along with metadata
        jpegWriter.write(new IIOImage(image, null, metadata));
    }
    finally {
        output.close();
    }

    jpegWriter.dispose();