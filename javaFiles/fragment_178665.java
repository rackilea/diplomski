public class snapObserver extends FileObserer {
    private Context mContext;

    //any code

    public snapObserver(String path, Context context) {
        super(path, FileObserver.CREATE);

        this.mContext = context;
    }

    //any code
}