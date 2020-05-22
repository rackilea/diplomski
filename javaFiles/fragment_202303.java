private void showFileChooser() {
    Intent intent = new Intent(Intent.ACTION_GET_CONTENT); 
    intent.setType("*/*"); 
    intent.addCategory(Intent.CATEGORY_OPENABLE);

    try {
        startActivityForResult(
                Intent.createChooser(intent, "Select a File to Upload"),
                FILE_SELECT_CODE);
    } catch (android.content.ActivityNotFoundException ex) {
        // Potentially direct the user to the Market with a Dialog
        Toast.makeText(this, "Please install a File Manager.", 
                Toast.LENGTH_SHORT).show();
    }
}