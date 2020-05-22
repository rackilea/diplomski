parent.runOnUiThread(new Runnable() {
       public void run() {
          AlertDialog.Builder builder = new AlertDialog.Builder(parent);
          builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 exit = true;
             }
          });
          builder.setTitle("Enter...");
          AlertDialog dialog = builder.create();
          dialog.show();
       }
    });