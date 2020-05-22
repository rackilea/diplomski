if(click %2 !=0){
    text.setText("-"+text.getText());
}
else{
    // remove your first character (- sign)
    text.setText(text.getText().substring(1));
}