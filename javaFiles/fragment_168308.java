class Entity {
    public Entity copy() {
        return new Entity();
    }
}

class Crate extends Entity {
    private String id;

    public Crate(Crate other) {
        // Copy whatever you need here from the other Crate object
        this.id = other.id;
    }

    @Override
    public Entity copy() {
        return new Crate(this);
    }
}