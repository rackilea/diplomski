//call this from onViewCreated to grab focus and begin the flow
editText.requestFocus();
//set focus listener to handle keyboard display
editText.setOnFocusChangeListener(new OnFocusChangeListener() {
     @Override
     public void onFocusChange(View v, boolean hasFocus) {
          if (!hasFocus) {
              InputMethodManager imm = (InputMethodManager)getSystemService(
  Context.INPUT_METHOD_SERVICE);
              imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
     } else {
              InputMethodManager imm = (InputMethodManager)getSystemService(
  Context.INPUT_METHOD_SERVICE);
              imm.showSoftInputFromWindow(myEditText.getWindowToken(), 0);
     }
});