public void onFocusChange(View view, boolean hasFocus) {
    if (hasFocus && 
            linearLayout.getChildAt(linearLayout.getChildCount() - 1) == view) {
        produsnou();
    }
}