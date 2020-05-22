public class MyApi {
    private final Function<String, OutputStream> fileProvider;
    private OutputStream current;
    public MyApi (Function<String, OutputStream> fileProvider, String defaultFile) {
        this.fileProvider = fileProvider;
        selectNewOutputFile(defaultFile);
    }
    public void selectNewOutputFile(String name) {
        OutputStream current = this.current;
        this.current = fileProvider.apply(name);
        if(current != null) current.close();
    }
}