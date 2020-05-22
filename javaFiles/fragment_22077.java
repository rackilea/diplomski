public void set1(View v)
{
    EditText tv = (EditText) findViewById(R.id.textView1);
    String text=tv.getText().toString();
    tv.setText(text+"1");
}