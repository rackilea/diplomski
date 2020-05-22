protected Dialog onCreateDialog(int id) {
        switch(id) {
        case DIALOG_DELETEDB:
            // do the work to define the pause Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                     Favs.this.finish();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                     dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            return alert;
        }

return null;
    }