public static void removeByPath(String path) {
    mm.get("2").removeIf(
        image -> Optional.ofNullable(image).map(Image::getPath)
                .filter(imagePath -> imagePath.contains(path)
                                  && image.getStatus().equals(ImageState.DONE))
                .isPresent()
        );
}