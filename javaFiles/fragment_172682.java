@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mGame=new XSI0();  // initialize the variable first
    mBoardsButtons = new Button[mGame.getMarimeTabla()];