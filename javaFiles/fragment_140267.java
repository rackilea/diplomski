public void alertDialog(String message,String title){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
            this);

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
            .setMessage(message)
            .setPositiveButton("OK", null) //we write null cause we don't want 
//to perform any action after ok is clicked, we just want the message to disappear 


            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }