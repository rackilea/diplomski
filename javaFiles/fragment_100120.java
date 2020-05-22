MediaPlayer mediaPlayer = new MediaPlayer(hit);
mediaPlayer.play();

// never do this:
//Thread.sleep(10000);

PauseTransition pause = new PauseTransition(Duration.millis(10000));
pause.setOnFinished(e -> {
    System.out.println("Fade");
});
pause.play();