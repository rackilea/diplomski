public void init(Image[] images) {
    this.imgView = new ImageView(images[0]);
    Timeline timeLine = new Timeline();
    Collection<KeyFrame> frames = timeLine.getKeyFrames();
    Duration frameGap = Duration.millis(256);
    Duration frameTime = Duration.ZERO ;
    for (Image img : images) {
        frameTime = frameTime.add(frameGap);
        frames.add(new KeyFrame(frameTime, e -> imgView.setImage(img)));
    }
    timeLine.setCycleCount(Timeline.INDEFINITE);
    timeLine.play();
}