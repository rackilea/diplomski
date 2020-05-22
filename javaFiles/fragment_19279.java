new AlertDialog.Builder(context)
    .setTitle("Close Application")
    .setMessage("Do you want to close the Application?")
    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) { 
            finish();
        }
     })
    .setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) { 
            // do nothing
        }
     })
    .setIcon(android.R.drawable.ic_dialog_alert)
     .show();