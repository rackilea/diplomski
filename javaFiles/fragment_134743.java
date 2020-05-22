enum GameObjectFactory {

    WALL(42) {
        @Override
        GameObject create() {
            return new Wall();
        }
    };

    private final int id;

    private GameObjectFactory(int id) {
        this.id = id;
    }

    abstract GameObject create();

    static GameObjectFactory getById(int id) {
        for (GameObjectFactory factory : values()) {
            if (factory.id == id) {
                return factory;
            }
        }
        throw IllegalArgumentException("Invalid ID: " + id);
    }
}