NavigableMap<Double, Runnable> runnables = new TreeMap<>();

runnables.put(0.3, this::30PercentMethod);
runnables.put(1.0, this::70PercentMethod);

public static void runRandomly(Map<Double, Runnable> runnables) {
    double percentage = Math.random();
    for (Map.Entry<Double, Runnable> entry : runnables){
        if (entry.getKey() < percentage) {
            entry.getValue().run();
            return; // make sure you only call one method
        }
    }
    throw new RuntimeException("map not filled properly for " + percentage);
}

// or, because I'm still practicing streams by using them for everything
public static void runRandomly(Map<Double, Runnable> runnables) {
    double percentage = Math.random();
    runnables.entrySet().stream()
        .filter(e -> e.getKey() < percentage)
        .findFirst().orElseThrow(() -> 
                new RuntimeException("map not filled properly for " + percentage))
        .run();
}