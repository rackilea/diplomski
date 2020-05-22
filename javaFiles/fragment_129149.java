private void shrinkText(CharSequence text, TextView v){

if(text.length()>25){

    v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);

    }
else {
   v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25); //the default text size
}
}