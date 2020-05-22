// Your alert dialog config
...
final AlertDialog alertDialog = alertDialogBuilder.create();
alertDialog.show();

// disable the button as default start
alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);

// add TextWatcher for EditText
editTextAssignmentName.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {

        if (s.length() >= 1) { // add your condition here, in your case it is checkIfNameAlreadyExists
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
        } else {
            alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
        }
    }
});