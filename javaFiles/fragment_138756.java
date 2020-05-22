Button button,button1;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.mainmenu);
    button = (Button) findViewById(R.id.button9);
    button1 = (Button) findViewById(R.id.button1);
    addListenerOnButtonNews();     
    addListenerOnButtonGPS() 
    }