TextWatcher tw = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Btn.setEnabled(!TextUtils.isEmpty(firstEditText.getText()) && !TextUtils.isEmpty(secondEditText.getText()));
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
};

firstEditText.addTextChangedListener(tw);
secondEditText.addTextChangedListener(tw);