final EditText emailEditTxt= (EditText)findViewById(R.id.text); 

String emailStr = emailEditTxt.getText().toString().trim();

if(emailStr!=null)

if(emailStr.length()>=1){

String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


if (emailStr .matches(emailPattern))
{
Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
}
else 
{
Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
}
}