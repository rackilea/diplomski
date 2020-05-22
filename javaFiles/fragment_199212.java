tv = (TextView)findViewById(R.id.charCounts);
textMessage = (EditText)findViewById(R.id.textMessage);
textMessage.addTextChangedListener(new TextWatcher(){
    public void afterTextChanged(Editable s) {
    }
    public void beforeTextChanged(CharSequence s, int start, int count, int after){}
    public void onTextChanged(CharSequence s, int start, int before, int count){
        //Check if text is hexadecimal
    }
});