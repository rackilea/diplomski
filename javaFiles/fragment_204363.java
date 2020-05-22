@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(new SingleTouchEventView(this, null));
    //add xml layout to Activity Window
    LayoutInflater inflater = getLayoutInflater();
    getWindow().addContentView(inflater.inflate(R.layout.activity_main, null),
                              new ViewGroup.LayoutParams(
                               ViewGroup.LayoutParams.MATCH_PARENT,
                               ViewGroup.LayoutParams.MATCH_PARENT));

}