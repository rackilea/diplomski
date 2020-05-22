enum State{
    IDLE, MOVING, ATTACKING;
}

class Entity {
    private State[] states;

    protected Entity(State... states) {
        this.states = states;
    }

}

class Character extends Entity{
    public Character() {
        super(State.IDLE, State.MOVING, State.ATTACKING);
    }
}

class MovingEntity extends Entity{
    public MovingEntity() {
        super(State.IDLE, State.MOVING);
    }
}