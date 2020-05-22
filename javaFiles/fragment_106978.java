File f1 = stegoImageSaver.showSaveDialog(null);
if (f1 != null) {
    String name = f1.getName();
    String extension = name.substring(1+name.lastIndexOf(".")).toLowerCase();
    ImageIO.write(img, extension, f1);
}