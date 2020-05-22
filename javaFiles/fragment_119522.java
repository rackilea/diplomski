mEditText.addTextChangedListener(new TextWatcher()
{
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int aft                                                                           
    {
    }

    @Override
    public void afterTextChanged(Editable s)
    {
       // this will show characters remaining
        countTextView.setText(150 - s.toString().length() + "/150");
    }
});