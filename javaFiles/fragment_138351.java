final ImageOutputStream stream = ImageIO.createImageOutputStream(outFile);
System.out.println("Output file: " + outFile);
try {
    writer.setOutput(ImageIO.createImageOutputStream(outFile));
    writer.write(metadata, new IIOImage(image_to_save, null, metadata),
    writeParam);
} catch (Exception e) {
    System.out.println("Caught exception " + e + " when trying to write out
        file.");
    System.exit(0);
} finally {
    stream.close();
}