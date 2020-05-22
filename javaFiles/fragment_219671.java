EditText editText1 = (EditText)findViewById(R.id.editText1);
double pro;
try {
    if(editText1 != null) {
        pro = Double.parseDouble(editText1.getText().toString());
    } else {
        // you have an coding problem ;-)
        // this should now just happen if you change the id in your xml
    }
} catch(NumberFormatException e) {
    // input was no number or an empty string
}