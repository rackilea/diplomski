class Asteroid implements Moving {
    private final Inertia inertia;
    private Shape shape = new Circle(radius);

    @Override
    public void move() {
        inertia.move(shape);
    }

    @Override
    public boolean hasCollided(Shape other) {
        return this.shape.intersects(other);
    }

    @Override
    public void handleCollision(Collision collision) {
        intertia.applyForceFrom(collision.getCentreOfMass());
    }
}