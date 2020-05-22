@Override
protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_second);

     final ResObj yourObject = getIntent().getParcelableExtra("your_key"); // make sure you use same key like data.

     // Now you can use your data like that
     yourEditText.setText(yourObject.getEmail()); 
}