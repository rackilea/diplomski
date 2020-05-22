public static <T extends GameCommand> Pool<T> createCommandPool(final Class<T> clazz) {
    return new Pool<T>() {
        @Override protected T newObject() {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e); // cause there isn't really much else you can do.
            }
        }
    };
}

public static void main(String[] args) {
    Pool<? extends GameCommand> gcPool = createCommandPool(GameCommand.class);
    // MyCommand extends GameCommand
    Pool<? extends GameCommand> mcPool = createCommandPool(MyCommand.class);
}