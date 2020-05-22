File file = new File("test.html");
try {
    Files.write(file.toPath(), content.getBytes());
    Desktop.getDesktop().browse(file.toURI());
} catch (IOException e) {
    // TODO Auto-generated catch block
}