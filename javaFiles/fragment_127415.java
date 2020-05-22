private void savePreferences(){
    // We need an Editor object to make preference changes.
    SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
    editor.putString("editText1", editText1.getText().toString());
    editor.putString("editText2", editText2.getText().toString());

    // Commit the edits!
    editor.commit();
}

private void restorePreferences() {
    SharedPreferences settings = getPreferences(MODE_PRIVATE);
    editText1.setText(settings.getString("editText1", ""));
    editText2.setText(settings.getString("editText2", ""));
}