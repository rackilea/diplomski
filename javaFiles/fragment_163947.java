public static Action<Void, Void> action(Runnable runnable) {
    return (v) -> {
        runnable.run();
        return null;
    };
}

// Somewhere else in your code
 Action<Void, Void> action = action(() -> System.out.println("foo"));