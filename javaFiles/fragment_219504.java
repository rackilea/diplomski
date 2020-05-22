public static void alertFailure(Context context, String errorTitle, String errorMessage) {
 Log.d("Alert Failure", "alerting failure");
        AlertDialog.Builder builder = new AlertDialog.Builder(context); // Needs context of loginactivity
        builder.setTitle(errorTitle);
        builder.setMessage(errorMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
}