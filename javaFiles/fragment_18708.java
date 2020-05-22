button1.setOnClickListener(new OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        String text = editText1.getText().toString();
        hitungMD5(text);
    }