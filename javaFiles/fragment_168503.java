.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int whichButton) {
    //at this point i am trying to exit the app
              Intent intent = new Intent(Intent.ACTION_MAIN);
              intent.addCategory(Intent.CATEGORY_HOME);
              intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(intent);
              finish();
              System.exit(0);

               }   
           })