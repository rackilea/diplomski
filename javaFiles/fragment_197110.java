public interface Dog<T extends Thing> {
    public List<T> fetchList();
}

public class Shepherd implement Dog<Ball> {
    public List<Ball> fetchList() { /* ... */ }
}