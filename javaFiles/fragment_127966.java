AlertDialog.Builder alert = new AlertDialog.Builder(this);

alert.setTitle("Title");
alert.setMessage("Message");

// Set an EditText view to get user input 
final EditText input = new EditText(this);
alert.setView(input);

alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int whichButton) {

  // Do something with value!
  }
});

alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
  public void onClick(DialogInterface dialog, int whichButton) {
    // Canceled.
  }
});

alert.show();