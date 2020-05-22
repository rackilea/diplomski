class Square extends Button {
    private ObjectProperty<SquareState> state = new SimpleObjectProperty(
        SquareState.EMPTY
    );

    public ObjectProperty<SquareState> stateProperty() {
        return state;
    }

    public SquareState getState() {
        return state.get();
    }

    public void setState(SquareState newState) {
        state.set(newState);
    }
}