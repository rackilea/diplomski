public MyActivity implements LoginListener {

    // instantiate the handler somewhere, with a reference
    // to "this". "this" refers to the LoginListener interface
    // which is implemented.
    @Override
    public void onCreate(Bundle b) {
        mHandler = new MyHandler(this);
    }

    @Override
    public void onLoginSuccess() {
        Log.i(TAG, "Kewel beanZ");
    }
}