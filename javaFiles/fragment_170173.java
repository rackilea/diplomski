final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
boolean agreed = sharedPreferences.getBoolean("agreed",false);
if (!agreed) {
    new AlertDialog.Builder(context)
        .setTitle("License agreement")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Editor editor = sharedPreferences.edit();
                editor.putBoolean("agreed", true);
                editor.commit();
            }
        })
        .setNegativeButton("No", null)
        .setMessage(text)
        .show();
}