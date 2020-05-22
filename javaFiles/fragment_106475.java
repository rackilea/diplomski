@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  int theme = loadTheme();        //Load your theme here!!!!
  CustomazationProcess.onActivityCreateSetTheme(this, theme);
  setContentView(R.layout.something1);

  findViewById(R.id.black).setOnClickListener(this);
  findViewById(R.id.yellow).setOnClickListener(this);
}