public void DialogDownLoad(String message,int pos)

{ 

      AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

      // set title
      alertDialogBuilder.setTitle("title");

      // set dialog message
      alertDialogBuilder.setMessage(message)
                  .setCancelable(false)
                  .setPositiveButton("Yes",new  DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        if(pos == 0){
                           // call downloadMap1();
                        }
                        if(pos == 1){
                          // call  downloadMap2();
                        }
                        ......................
                    }
                  })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        ...............   //your code
                    }
                });

// create alert dialog
AlertDialog alertDialog = alertDialogBuilder.create();
// show it
alertDialog.show();
}