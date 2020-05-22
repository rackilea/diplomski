alert.setButton(DialogInterface.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            // closing the application
            finish();
        }
    });