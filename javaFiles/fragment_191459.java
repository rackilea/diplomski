//in SignupActivity

String number=edittext.getText().toString();
Intent i = new Intent(SignupActivity.this, LoginActivity.class);
i.putExtra("your_number",number);
startActivity(i)
finish();