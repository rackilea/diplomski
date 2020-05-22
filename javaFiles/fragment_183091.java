final EditText input = new EditText(this);
AlertDialog.Builder alert = new AlertDialog.Builder(this)
    .setTitle("Please enter your name")
    .setView(input) // Use our EditText
    .setPositiveButton("Save", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            // Save value of `input.getText()`
        }
    }).show();