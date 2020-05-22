String url = "https://www.dropbox.com/s/vk67dz9ca0oqz37/Chrysanthemum.jpg?dl=1";
String filename = "C:\\Users\\Public\\Pictures\\Sample Pictures\\test.jpg";
try {
    URL download = new URL(url);
    Path fileOut = new File(filename).toPath();
    Files.copy(download.openStream(), fileOut, StandardCopyOption.REPLACE_EXISTING);
} catch (Exception e) {
    e.printStackTrace();
}