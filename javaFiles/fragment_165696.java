public static AlertDialog getAlertDialog(Context ctx, String title, String message, String posButton, boolean dismissable, final DialogInterface.OnClickListener ocl) {

    AlertDialog.Builder builder =new AlertDialog.Builder(ctx);
    builder.setTitle(title)
        .setMessage(message)
        .setCancelable(dismissable)
        .setPositiveButton(posButton,
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){
                    dialog.dismiss();
                    if(ocl!=null) ocl.onClick(dialog, id);
                }
            });

    AlertDialog dialog = builder.create();
    return dialog;
}