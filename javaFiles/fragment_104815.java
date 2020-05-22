public static void alertButtonDialog(final Activity activity, Context context, String title, String message, 
        String positiveButton, String negativeButton) {

    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
    ...
    alertBuilder.setPositiveButton(positiveButton, new OnClickListener() {

        public void onClick(DialogInterface dialog, int which) {
            activity.finish();
        }
    })

}