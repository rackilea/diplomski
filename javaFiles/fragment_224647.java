public void onCreate(Bundle b){

 Bundle extra = getIntent().getExtras();
    if (extra != null) {
        String textViewName = extra.getString("SomeTag");
        textView.setText(textViewName);
 }