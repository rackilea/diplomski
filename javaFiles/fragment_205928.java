EditText editText1 = (EditText)findviewById(R.id.editText1);
TextView textView1 = (TextView)findviewById(R.id.textView1);
plusBtn.setOnClickListener(new OnClickListener() {

    public void onClick(View v) 
    {
        textView1.append("\n"+editText1.getText().toString());
                         // OR
        textView1.setText(textView1.getText().toString()+"\n"+editText1.getText().toString());
    }
});