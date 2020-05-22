public class Click {

private AtomicInteger counter = new AtomicInteger(0);
private Map<Integer, String> matchup = new ConcurrentHashMap<>();

public void onClick(String input) {
    matchup.put(counter.incrementAndGet(), input);
}
}