private boolean animationRunning = false;
private void showRandomCard(){
    if (!animationRunning) {
        animationRunning = true;
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(400));
        tt.setNode(randomCard);
        tt.setFromY(950);
        tt.setFromX(-600);
        tt.setToY(0);
        tt.setToX(0);

        RotateTransition rt = new RotateTransition(Duration.millis(500), randomCard);
        rt.setByAngle(360);
        rt.setRate(1);
        rt.setCycleCount(1);
        rt.setOnFinished(evt -> animationRunning = false);

        tt.play();
        rt.play();
    }

}