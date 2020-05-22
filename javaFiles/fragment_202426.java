public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.id.viewFlipper);

    // use fragment manager to see which fragments are instantiated
    // and available, then reuse any available in case of
    // orientation change

    FragmentManager.enableDebugLogging(true)
    FragmentManager fragManager = getSupportFragmentManager();
    ListFragmentOne fragOne = fragManager.findFragmentById("frag one tag");

    // if fragOne is null add a new instance via an add transaction
    // etc.
}