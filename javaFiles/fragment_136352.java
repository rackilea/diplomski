Handler handler;

protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  // initialize Handler
  handler= new Handler(getMainLooper());

  txt= (TextView)findViewById(R.id.texte);
  handler.postDelayed(new Runnable() {
      @Override
      public void run() {
          txt.setText(String.valueOf(1020));
      }
  },  5000);