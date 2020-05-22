public void sendMessage(View view) {

    EditText editText = (EditText)findViewById(R.id.editText);
    TextView textView = (TextView)findViewById(R.id.textView);

    String textWritten = editText.getText().toString();
    textView.setText(textWritten);
 }