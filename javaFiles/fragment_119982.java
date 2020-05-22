EditText text;
private void foo()
{
    text.addTextChangedListener(new TextWatcher()
    {
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }

        public void afterTextChanged(Editable s)
        {
            // modify string here
        }
    });
}