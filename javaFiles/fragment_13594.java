EditText editText = (EditText)findViewById(R.id.editText);
Double num1 = 0.0;
final String myStr = editText.getText().toString();
if (!myStr.isEmpty())
{
    num1 = Double.parseDouble(myStr);
}
else
{
    Toast.makeText(getApplicationContext(), getResources().getString(R.string.noinput),
        Toast.LENGTH_LONG).show();
}