public void updateGui() {
    final KeyFrame kf1 = new KeyFrame(Duration.seconds(0), e -> doFirstStuff());
    final KeyFrame kf2 = new KeyFrame(Duration.seconds(1), e -> doSecondStuff());
    final KeyFrame kf3 = new KeyFrame(Duration.seconds(2), e -> doThirdStuff());
    final Timeline timeline = new Timeline(kf1, kf2, kf3);
    Platform.runLater(timeline::play);
}