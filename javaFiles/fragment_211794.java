EditText editText = (EditText) findViewById(R.id.editText);
editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged (CharSequence s,int start, int count,
    int after){
    }
    @Override
    public void onTextChanged ( final CharSequence s, int start, int before,
    int count){
        handler.removeCallbacks(input_finish_checker);

    }
    @Override
    public void afterTextChanged ( final Editable s){
        if (s.length() > 0) {
            last_text_edit = System.currentTimeMillis();
            handler.postDelayed(input_finish_checker, delay);
        } else {

        }
    }
}