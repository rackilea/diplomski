codigo.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        cod = s.toString();
        if(!cod.isEmpty() || !password.isEmpty())
        {
            botaologar.setClickable(true);
            botaologar.setEnabled(true);
        }
        else
        {
            botaologar.setEnabled(false);
            botaologar.setClickable(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});