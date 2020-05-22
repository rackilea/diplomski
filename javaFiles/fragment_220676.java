import java.util.concurrent.ThreadLocalRandom;
...
public long generateId() {
  ThreadLocalRandom random = ThreadLocalRandom.current();
  return random.nextLong(10_000_000_000L, 100_000_000_000L);
}