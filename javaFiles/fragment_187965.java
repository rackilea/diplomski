editText.setFocusable(false);
editText.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        editText.setFocusableInTouchMode(true);
        return false;
    }
});
editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    @Override
    public void afterTextChanged(Editable s) {
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
    }