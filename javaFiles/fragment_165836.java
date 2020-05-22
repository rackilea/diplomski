// Set an EditText view to get user input 
final EditText input = new EditText(Main.this);

new AlertDialog.Builder(Main.this)
    .setTitle("Update Status")
    .setMessage(message)
    .setView(input)
    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog, int whichButton) {
             editable = input.getText(); 
             // deal with the editable
         }
    })
    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog, int whichButton) {
             // Do nothing.
         }
    }).show();