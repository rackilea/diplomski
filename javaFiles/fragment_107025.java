yourTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_GO) { 
            //if textfield value is empty then close keyboard.
            //else call your search function.
        }
    }
});