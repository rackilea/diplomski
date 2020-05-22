PauseTransition idle = new PauseTransition(Duration.seconds(1));
idle.setOnFinished(e -> scene.setCursor(Cursor.NONE));
scene.addEventHandler(Event.ANY, e -> {
    idle.playFromStart();
    scene.setCursor(Cursor.DEFAULT);
});