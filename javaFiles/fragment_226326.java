public static AlertDialog generateDialog(Context ctx,
                                                String title,
                                                String message,
                                                @NonNull DialogInterface.OnClickListener positiveClick,
                                                DialogInterface.OnClickListener negativeClick) {

    AlertDialog.Builder adb = new AlertDialog.Builder(ctx);

    adb.setTitle(title);
    adb.setMessage(message);
    adb.setPositiveButton(ctx.getString(R.string.alert_ok), positiveClick);

    if(negativeClick != null) {
        adb.setNegativeButton(ctx.getString(R.string.alert_cancel), negativeClick);
    }
    else {
        adb.setNegativeButton(ctx.getString(R.string.alert_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }


    return adb.create();
}