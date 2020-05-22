AlertDialog.Builder adb = new AlertDialog.Builder(context);
..... //set up title, message, etc
adb.setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        callback.invoke(origin, false, false);
    }
});
adb.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) {
        callback.invoke(origin, true, false);
    }
});
adb.show();