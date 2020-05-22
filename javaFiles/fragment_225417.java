String str = fromEditText.getText().toString().trim();
boolean valid = true;
double val = 0;

try {
    val = Double.parseDouble(str);
}
catch(NumberFormatException e) {
    valid = false;
}

if( valid ) {
    // use the number
}
else {
    // handle invalid entry
}