public void changeState(State state) {
    this.state = state;
    for (SomeObject obj : objects) {
        obj.state = state;
    }
}