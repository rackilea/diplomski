protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    texte = (TextView) findViewById(R.id.text_edt);
    texte.setText("erreur internet");
    setContentView(R.layout.activity_main);  // remove this line and it should fix your problem
}