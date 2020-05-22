public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);

  Bundle extras = this.getIntent().getExtras();
  if (extras != null && extras.containsKey("name")) {
      String userName = this.getIntent().getExtras().getString("name");
  }
}