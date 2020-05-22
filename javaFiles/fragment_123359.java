String extraHourString = txthorasextras.getText();
if(extraHourString.isEmpty()) { //alternatively, if(extraHourString.equals("")) {
    ... //handle the text being empty, or set a boolean flag so that you can handle it later
}
else { // we know the provided text is not empty now
    //will still crash on gibberish inputs, but the empty string "" will never reach here
    horas_extras = Integer.parseInt(extraHourString);
}