enum State{
    GOOD(1), BAD(-1), UGLY(0);

    int id;

    State(int id) {
        this.id = id;
    }

    @JsonValue
    int getId() {
        return id;
    }

    @JsonCreator
    static State fromId(int id){
        return Stream.of(State.values()).filter(state -> state.id == id).findFirst().get();
    }

}