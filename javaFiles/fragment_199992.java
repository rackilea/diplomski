Services.get(PicturesService.class).ifPresent(pictures -> {
    // 1. Retrieve picture from gallery
    pictures.loadImageFromGallery().ifPresent(image -> {
        // 2. Convert image to file
        File imageFile = getImageFile(image);

        // 3. Share file
        if (imageFile != null) {
            Services.get(ShareService.class).ifPresent(share -> {
                share.share("image/png", imageFile);
            });
        }
    });
});