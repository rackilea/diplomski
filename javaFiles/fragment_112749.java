private GestureDetector gestureDetector;


@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);

    setContentView(R.layout.themes);

    ActionBar actionBar = getActionBar();
    actionBar.hide();

    RelativeLayout ll = (RelativeLayout) findViewById(R.id.myLayout);
    gestureDetector = new GestureDetector(Softkeys.this, this);

    /* Your stuff */

}