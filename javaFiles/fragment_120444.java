public void write(MultipartFile file, Path dir) {
    Path filepath = Paths.get(dir.toString(), file.getOriginalFilename();

    try (OutputStream os = Files.newOutputStream(filepath)) {
        os.write(file.getBytes());
    }
}