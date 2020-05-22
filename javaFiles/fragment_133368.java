public static void main(String... args) throws IOException {
    InputStream imageStream = Test.class.getClass().getResourceAsStream("/test/DSC_6283.jpg");
    Path path = Files.createTempFile("DSC_6283", ".jpg");
    try (FileOutputStream out = new FileOutputStream(path.toFile())) {
        byte[] buffer = new byte[1024]; 
        int len; 
        while ((len = imageStream.read(buffer)) != -1) { 
            out.write(buffer, 0, len); 
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
    Desktop.getDesktop().open(path.toFile());
}