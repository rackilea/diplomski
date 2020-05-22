if (click == 0) {
    ... turn card face up ...

    PauseTransition transition = new PauseTransition(Duration.millis(500));
    transition.setOnFinished(evt -> {
        ... turn cards face down ...
    });
    transition.play();
}