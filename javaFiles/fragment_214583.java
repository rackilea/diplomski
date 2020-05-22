public void showAlert(){

    YourActivityName.this.runOnUiThread(new Runnable() {
        @Override
        public void run() {


            new AlertDialog.Builder(YourActivityName.this)
                    .setTitle("OK")
                    .setMessage("OK")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }
    });

}