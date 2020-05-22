public static byte[] resize(byte[] img) throws IOException {
    byte[] outimage = null;

    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(30000);
        ImageOutputStream ios = ImageIO.createImageOutputStream(baos);

        ImageReader reader = getTiffImageReader();
        ImageInputStream imageStream = ImageIO.createImageInputStream(new ByteArrayInputStream(img));
        reader.setInput(imageStream);

        int pages = reader.getNumImages(true);

        Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("TIFF");
        ImageWriter writer = imageWriters.next();

        writer.setOutput(ios);
        ImageWriteParam writeParam = writer.getDefaultWriteParam();
        writeParam.setTilingMode(ImageWriteParam.MODE_DEFAULT);

        writer.prepareWriteSequence(reader.getStreamMetadata()); // You want the stream metadata here

        for (int i = 0; i < pages; i++) {
            IIOImage iioImage = reader.readAll(i, null); // Save some lines by using readAll

            BufferedImage image = (BufferedImage) iioImage.getRenderedImage();

            // Modify image here...                

            iioImage.setRenderedImage(image);

            writer.writeToSequence(iioImage, writeParam);
        }

        writer.endWriteSequence(); // Crucial, must be done outside loop

        ios.flush();
        ios.close();

        outimage = baos.toByteArray();            
        baos.close();

        writer.dispose();
        reader.dispose();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return outimage;
}