@Data
public class SearchResult {
    private final boolean found;
    private final int index;
}
...
public interface Container<T> {
     ...
     public SearchResult search(T key);
}