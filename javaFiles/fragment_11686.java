ImageInputStream input = ImageIO.createImageInputStream(new File(filePath));

try {
    Iterator<ImageReader> readers = ImageIO.getImageReaders(input);

    if (readers.hasNext()) {
        ImageReader reader = readers.next();

        try {
            reader.setInput(input);

            BufferedImage image = reader.read(0);  // Read the same image as ImageIO.read

            // Do stuff with image...

            // When done, either (1):
            String format = reader.getFormatName(); // Get the format name for use later
            if (!ImageIO.write(image, format, outputFileOrStream)) {
                // ...handle not written
            }
            // (case 1 done)

            // ...or (2):
            ImageWriter writer = ImageIO.getImageWriter(reader); // Get best suitable writer

            try {
                ImageOutputStream output = ImageIO.createImageOutputStream(outputFileOrStream);

                try {
                    writer.setOutput(output);
                    writer.write(image);
                }
                finally {
                    output.close();
                }
            }
            finally {
                writer.dispose();
            }
            // (case 2 done)
        }
        finally {
            reader.dispose();
        }
    }
}
finally {
    input.close();
}