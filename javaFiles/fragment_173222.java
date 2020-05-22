private static final Map<Integer, Action> actions = new HashMap<>(values().size, 1);

static {
    for (Action action : values())
        actions.put(action.code, action);
}

// ...

public static Action valueOf(int what) {
    return actions.get(what);
}