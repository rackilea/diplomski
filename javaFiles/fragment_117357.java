URL url = new URL("url")
File file = new File("New File Path");
InputStream inputStream = url.openStream();
OutputStream outputStream = new FileOutputStream(file);
        try {
            IOUtils.copy(inputStream, outputStream);
        } finally {
            outputStream.close();
            inputStream.close();
}
BufferedImage actualImage = ImageIO.read(file);