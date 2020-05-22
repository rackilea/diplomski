interface GameObjectFactory {
    GameObject create(); // this could also take arguments like x, y, and parent
}

private static final Map<Integer, GameObjectFactory> FACTORIES_BY_ID;
static {
    final Map<Integer, GameObjectFactory> factoriesById = new HashMap<>();

    // ID 42 is for walls
    factoriesById.put(42, new GameObjectFactory() {
        @Override
        public GameObject create() {
            return new Wall();
        }
    });

    //etc.

    FACTORIES_BY_ID = factoriesById;
}