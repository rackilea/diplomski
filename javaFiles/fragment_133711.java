public class MyClass implements MyInterface {

    private WeakReference<Context> mContext;

    public MyClass(Context context) {
        this.mContext = new WeakReference<Context>(context);
    }

    @Override
    public void myAction() {
        Context ctx = mContext.get();
        if (ctx != null){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
            //do stuff
        }
    }
}