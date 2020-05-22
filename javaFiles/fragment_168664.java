File sourceFile = new File(fullPath);               
try {
    BufferedImage bufferedimage = ImageIO.read(sourceFile);

    //scaleImage(bufferedimage, 220, 220);  

    // Beware, this is overwriting the existing file
    try (FileOutputStream fileOutputStream = new FileOutputStream(sourceFile)) {
        ImageIO.write(bufferedimage, "jpg", fileOutputStream);
    }
} catch(Exception e) {
    e.printStackTrace();
}