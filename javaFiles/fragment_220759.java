class Inertia implements Moving {
    private Velocity velocity;

    @Override
    public void move(Shape shape) {
        velocity.applyTo(shape);
    }

    @Override
    public void applyForceFrom(Position position) {
        velocity.accelerateAwayFrom(position);
    }
}