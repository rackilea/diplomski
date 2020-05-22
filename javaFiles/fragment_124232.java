// Initialize e1
EditText e1 = (EditText) findViewById(R.id.input);

// Take text from e1 and assign it to str
String str = e1.getText().toString();

// Initialize out
TextView out= (TextView) findViewById(R.id.output);

// Set text in str to EditText out
out.setText(str);