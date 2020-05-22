private TextWatcher addTextWatcher = new TextWatcher() {
    @Override
    public void onTextChanged(CharSequence sequence, int start, int before, int count) {
        // here is where you could grab the contents of the edittext 
        // input each time a character is entered, and pass the value 
        // off to your unit conversion code. Careful to check for 
        // numerals/decimals only, or to set the proper inputType in 
        // your xml.
    }
    @Override
    public void beforeTextChanged(CharSequence sequence, int start, int count, int after) { 

    }
    @Override
    public void afterTextChanged(Editable sequence) { 

    }
};