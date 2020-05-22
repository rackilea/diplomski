@Override
protected void onCreate(Bundle savedInstanceState) {
    mImpl = ActionBarActivityDelegate.createDelegate(this);
    super.onCreate(savedInstanceState);
    mImpl.onCreate(savedInstanceState);
}