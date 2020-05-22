public class Server {

    private Context mContext;
    public Server(Context context) {
        mContext = context;
        ...
    }
    ...
    public String loadJSONFromAsset() {
        ...
            mContext.getAssets().open("cat.json");
    }
}