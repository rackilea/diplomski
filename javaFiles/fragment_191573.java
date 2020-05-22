public static void removeByPath(String path) {
    mm.get("2").stream()
            .filter(Objects::nonNull)
            .filter(image -> Optional.ofNullable(image.getPath())
                    .filter(imagePath -> imagePath.contains(path)
                                      && image.getStatus().equals(ImageState.DONE))
                    .isPresent()
            ).forEach(img -> {
        mm.values().remove(img);
    });
}