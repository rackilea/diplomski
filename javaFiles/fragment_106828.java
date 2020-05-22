try{
    x = Double.valueOf(nop.getText().toString());
} catch (NumberFormatException e) {
    x = 0;
}

try{
    y = Double.valueOf(cop.getText().toString());
} catch (NumberFormatException e) {
    y = 1; // division / 0 will throw NaN
}