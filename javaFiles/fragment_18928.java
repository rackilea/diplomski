PauseTransition hideCircle = new PauseTransition(Duration.seconds(1));
PauseTransition hideRectangle = new PauseTransition(Duration.seconds(1));

// restart hideCircle if mouse moves in window:
scene.addEventFilter(MouseEvent.MOUSE_MOVED, e -> hideCircle.playFromStart());

// restart hideRectangle if mouse enters rectangle:
rectangle.setOnMouseEntered(e -> hideRectangle.playFromStart());

// hide circle if pause gets to end:
hideCircle.setOnFinished(e -> circle.setVisible(false));

// hide rectangle if pause gets to end:
hideRectangle.setOnFinished(e -> rectangle.setVisible(false));

// start "timers":
hideCircle.play();
hideRectangle.play();