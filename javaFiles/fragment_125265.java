Timeline playtime = new Timeline(
    new KeyFrame(Duration.seconds(0), event -> anim.play()),
    new KeyFrame(Duration.seconds(2), event -> anim.pause()),
    new KeyFrame(Duration.seconds(3), event -> anim.play())
);
playtime.play();