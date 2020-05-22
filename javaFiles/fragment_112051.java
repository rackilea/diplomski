public Mono<Void> deleteImage(String fileId) {
  return imageRepository.findById(fileId)
           .flatMap(image -> Mono.when(deleteFile(image), deleteRecord(image)).then());
}

private Mono<Void> deleteRecord(Image image) {
  return imageRepository.delete(image);
}

private Mono<Void> deleteFile(Image image) {
  return Mono.fromRunnable(() -> {
    try {
      Files.deleteIfExists(Paths.get(UPLOAD_ROOT, image.getId() + "-" + image.getName()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  })
}