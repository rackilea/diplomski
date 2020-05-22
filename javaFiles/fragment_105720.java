private final BooleanProperty gameEnded = new SimpleBooleanProperty();

public BooleanProperty gameEndedProperty() {
    return gameEnded ;
}

public final boolean isGameEnded() {
    return gameEndedProperty().get();
}

public final void setGameEnded(boolean gameEnded) {
    gameEndedProperty().set(gameEnded);
}