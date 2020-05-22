public static void main(String[] args) {
    final String directoryPath = "C:\\images";
    final String outputPath = "C:\\images\\out";
    final int color = 0x00ff0000;
    File directory = new File(directoryPath);
    File[] files = directory.listFiles();

    if (files == null) {
        return;
    }

    for (File file : files) {
        String extension;

        int extensionIndex = file.getName().lastIndexOf('.');
        if (extensionIndex > 0) {
            extension = file.getName().substring(extensionIndex + 1);
        } else {
            extension = "bmp";
        }

        BufferedImage image;
        try {
            image = convert(ImageIO.read(file), BufferedImage.TYPE_INT_ARGB);
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    image.setRGB(i, j, image.getRGB(i, j) | color);
                }
            }

            File newFile = new File(outputPath + "\\" + file.getName());
            ImageIO.write(image, extension, newFile);
        } catch (IOException e) {
            // Handle
        }
    }
}