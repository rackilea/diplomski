if(dialog == null){
            dialog = ProgressDialog.show(this,"","Retrieving listings please wait...");
            //display progress dialog while querying server for values
            dialog.setCancelable(true);
            dialog.show();
        }