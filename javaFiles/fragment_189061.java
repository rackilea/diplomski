editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//save it to file here or what ever you want
    }

    @Override
    public void afterTextChanged(Editable s) {}
});