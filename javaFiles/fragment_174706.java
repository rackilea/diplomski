EditText e1 = (EditText) findViewById(R.id.edit_text_1);
EditText e2 = (EditText) findViewById(R.id.edit_text_2); 
double a1 = Double.parseDouble(e1.getText().toString())
double a2 = Double.parseDouble(e2.getText().toString());
Log.e("a1", a1 + "");
Log.e("a2", a2 + "");
Log.e("Result", String.format("%.2f", (a1-a2) + ""));