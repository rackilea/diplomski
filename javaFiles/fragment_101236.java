class FastMovingEntity extends MovingEntity{
    public FastMovingEntity() {
        super(State.MOVING_FAST);
    }
}

class MovingEntity extends Entity{
    public MovingEntity(State... states) {
        super(...);
    }
}