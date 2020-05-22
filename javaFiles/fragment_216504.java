class Utility {
    static void alertDialogShow(Context context, String title, String message, OnClickListener listener) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", listener);
        alertDialog.show();
    }

    static void alertDialogShow(Context context, String title, String message) {
        alertDialogShow(context, title, message, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
    }
}