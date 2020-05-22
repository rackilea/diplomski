public interface Box<T> {
    T getContent();
}

public class StringBox implements Box<String> {

    private String contents;

    String getContent();
}