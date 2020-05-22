protected void applyTextWatcher(EditText roundInput, TextView boxerTotalText, EditText[] roundInputList){
    roundInput.addTextChangedListener(new TextWatcher() {
        ....
        @Override
        public void afterTextChanged(Editable editable) {
          boxerTotalText.setText(String.valueOf(sumRounds(roundInputList)));
        }
    });
}