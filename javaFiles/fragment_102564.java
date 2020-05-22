public void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
   // get Intent here
    Intent it = getIntent();
    String[] imageIDs = it.getStringArrayExtra("imageArray");
}