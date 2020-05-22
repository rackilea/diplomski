String note;

onCreate(){
    note = getSharedPref(NOTE);
}

onClick(){
    putSharedPref(info.getText());
    views.setText(note);
}