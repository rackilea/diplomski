edtTxt.requestFocus();
edtTxt.setText("");
InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

inputMethodManager.toggleSoftInputFromWindow(edtTxt.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED,
            0);