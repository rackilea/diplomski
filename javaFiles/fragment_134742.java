private static final GameObjectFactory[] FACTORIES = {
    // ID 0 is for walls
    new GameObjectFactory() {
        @Override
        public GameObject create() {
            return new Wall();
        }
    }
};