String url = "https://www.dropbox.com/s/vk67dz9ca0oqz37/Chrysanthemum.jpg?dl=1";
String filename = "C:\\Users\\Public\\Pictures\\Sample Pictures\\test.jpg";
try {
    URL download = new URL(url);
    ReadableByteChannel rbc = Channels.newChannel(download.openStream());
    FileOutputStream fileOut = new FileOutputStream(filename);
    fileOut.getChannel().transferFrom(rbc, 0, 1 << 24);
    fileOut.flush();
    fileOut.close();
    rbc.close();
} catch (Exception e) {
    e.printStackTrace();
}