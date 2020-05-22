public class Main {
    private static final Map<Keyboard.Key, Action> gameKeys = new HashMap<>();
    private static final Map<String, Class<? extends Action>> actions = new HashMap<>();

    static {
        actions.put(FireAction.NAME, FireAction.class);
        actions.put(WalkAction.NAME, WalkAction.class);    
    }

    public static void main(String[] args) {
        // read from file etc.

        try {
            // e.g. found  SPACE : FIRE_ACTION
            gameKeys.put(Keyboard.Key.SPACE, actions.get("FIRE_ACTION").newInstance());

            // e.g. found A : WALK_ACTION
            gameKeys.put(Keyboard.Key.A, actions.get("WALK_ACTION").newInstance());
        } catch (IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }
}