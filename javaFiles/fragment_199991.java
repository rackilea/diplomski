private File getImageFile(Image image) {
    if (image == null) {
        return null;
    }

    // 1. Encode image to png
    PngEncoderFX encoder = new PngEncoderFX(image, true);
    byte[] bytes = encoder.pngEncode();

    // 2.Write byte array to a file in public storage 
    File root = Services.get(StorageService.class)
            .flatMap(storage -> storage.getPublicStorage("Pictures"))
            .orElse(null);
    if (root != null) {
        File file = new File(root, "Image-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuuMMdd-HHmmss")) + ".png");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);
            return file;
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
    return null;
}