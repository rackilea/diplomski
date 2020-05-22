new AlertDialog.Builder(YourActivity.this)
         .setTitle(Html.fromHtml("<font color='#000000'> Your black title </font>"))
         .setView(yourView)
         .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                      //Stuff to do
                   }
              })
         .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                      //Stuff to do
                      dialog.dismiss();
                   }
               })
         .show();