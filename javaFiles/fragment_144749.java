// Declare a global variable first
private final int ACTION_LOCATION_SETTING = 100;

// Now change the onClickListener like this
dialog.setPositiveButton("Take me to location services", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        Intent locationSettingIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivityForResult(locationSettingIntent, ACTION_LOCATION_SETTING);
    }
});