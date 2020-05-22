final View add_test_view = getLayoutInflater().inflate(R.layout.add_test_menu, null); 

final EditText test_title = (EditText) add_test_view. findViewById(R.id.testTitle);

 continue_button.setOnClickListener(new View.OnClickListener() { 

@Override public void onClick(View v) {
   String user_title = test_title.getText().toString();
 Log.i(TAG, "onClick: " + user_title); } });