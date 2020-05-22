ed1.setOnFocusChangeListener(new OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus)
            editTextClicked(); // Instead of your Toast
    }
});