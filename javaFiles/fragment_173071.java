ObservableList<Tab> tabs = tabPane.getTabs();
PauseTransition p = new PauseTransition(Duration.millis(150 + 20));
scene.setOnKeyPressed(e -> {
    Tab remove = tabs.remove(0);
    p.setOnFinished(e2 -> tabs.add(1, remove));
    p.play();
});