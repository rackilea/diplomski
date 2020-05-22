editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (v == editText) {
                if (hasFocus) {
                    ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editText,
                            InputMethodManager.SHOW_FORCED); // open keyboard

                } else {
                    ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            editText.getWindowToken(), 0); // close keyboard
                }
            }
        }
    });