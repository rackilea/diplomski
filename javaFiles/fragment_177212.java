public class ResultFileWatcher extends Task<Object> {
    private Context context;

    public ResultFileWatcher(Context context) {
        this.context = context;
    }

    ...

    @Override
    protected Object call() throws Exception {
        //...
    }
}