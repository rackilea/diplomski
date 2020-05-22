ImageView view = new ImageView();
BufferedImage bImage = SwingFXUtils.fromFXImage(view.getImage(), null);
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
try {
    ImageIO.write(bImage, "png", outputStream);
    byte[] res  = outputStream.toByteArray();
    InputStream inputStream = new ByteArrayInputStream(res);
} catch (IOException e) {
    e.printStackTrace();
}