@Override
    public void onBackPressed() {
      AlertDialog diaBox = AskOption();
      diaBox.show();
    }

 private AlertDialog AskOption()
 {
    AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this) 
        .setTitle("Exit") 
        .setMessage("Are you sure you want to exit?") 
        .setIcon(R.drawable.delete)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) { 
            finish();
            }   
        })
        .setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        })
        .create();
        return myQuittingDialogBox;

    }