AlertDialog dialog = getAlertDialog(this,"Hello","World","OK",false,new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.i("DIALOG","OK Clicked");
        }
    });
    dialog.show();