System.out.println("in!");
AlertDialog.Builder dialog = new AlertDialog.Builder(this);
dialog.setMessage("test!!!");
dialog.setPositiveButton(R.string.dialog_ok, 
    new OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            // disable on 1st click;
            final AlertDialog alertDialog = (AlertDialog)dialog;
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(false);
            System.out.println("Only one click!");
        }
});
dialog.show();