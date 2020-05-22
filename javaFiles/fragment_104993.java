amountEditText.setRawInputType(Configuration.KEYBOARD_12KEY);
amountEditText.addTextChangedListener(new TextWatcher() {
    public void afterTextChanged(Editable s) {}
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

public void onTextChanged(CharSequence s, int start, int before, int count) {
    if(!s.toString().matches("^\\$(\\d{1,3}(\\,\\d{3})*|(\\d+))(\\.\\d{2})?$"))
    {
        String userInput= ""+s.toString().replaceAll("[^\\d]", "");
        StringBuilder cashAmountBuilder = new StringBuilder(userInput);

        while (cashAmountBuilder.length() > 3 && cashAmountBuilder.charAt(0) == '0') {
            cashAmountBuilder.deleteCharAt(0);
        }
        while (cashAmountBuilder.length() < 3) {
            cashAmountBuilder.insert(0, '0');
        }
        cashAmountBuilder.insert(cashAmountBuilder.length()-2, '.');
        cashAmountBuilder.insert(0, '$');

        amountEditText.setText(cashAmountBuilder.toString());
        // keeps the cursor always to the right
        Selection.setSelection(amountEditText.getText(), cashAmountBuilder.toString().length());

    }

}
});