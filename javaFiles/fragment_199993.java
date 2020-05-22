private Image scaleImage(Image source) {
    // Possible limit based on memory limitations
    double maxResolution = 1280; 

    double width = source.getWidth();
    double height = source.getHeight();
    double targetWidth = width;
    double targetHeight = height;
    if (width > maxResolution || height > maxResolution) {
        double  ratio = width/height;
        if (ratio > 1) {
            targetWidth = maxResolution;
            targetHeight = targetWidth/ ratio;
        }
        else {
            targetHeight = maxResolution;
            targetWidth = targetHeight * ratio;
        }
    }

    ImageView imageView = new ImageView(source);
    imageView.setPreserveRatio(true);
    imageView.setFitWidth(targetWidth);
    imageView.setFitHeight(targetHeight);
    return imageView.snapshot(null, null);
}