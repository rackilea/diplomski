public class Video {
    @Key
    private String title;
    public String getTitle() {
        return title;
    }
}

public class Response<TResult> {
    @Key
    private TResult result;
    public TResult getResult() {
        return result;
    }
    // ...
}