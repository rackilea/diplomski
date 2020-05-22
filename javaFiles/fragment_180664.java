@Override
 public void onBackPressed() {
     //super.onBackPressed();
     IsFinish("Want to close app?");
 }

 public void IsFinish(String alertmessage) {

      DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            android.os.Process.killProcess(android.os.Process.myPid());
                            // This above line close correctly
                            //finish();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:  
                            break;
                    }
                }
            };

      AlertDialog.Builder builder = new AlertDialog.Builder(context);
      builder.setMessage(alertmessage)
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

 }