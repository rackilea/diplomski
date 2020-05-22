public class Apple {
    static AtomicInteger nextId = new AtomicInteger();
    private int id;

    public Apple() {
        id = nextId.incrementAndGet();
   }
}