youreditText.setOnFocusChangeListener(new OnFocusChangeListener() {          

        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus) {
               InputMethodManager imm =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
               imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
    });