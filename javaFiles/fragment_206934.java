File oldFile = new File("a.ico");
try (InputStream inputStream = new FileInputStream(oldFile)) {
     List<BufferedImage> bi = ICODecoder.read(inputStream);
     ImageIO.write(bi.get(0), "png", new File("a" + ".png"));

} catch (IOException e) {
    LOG.error("Something happend", e);
}
FileUtils.moveFile(oldFile, new File("a.jpg"));