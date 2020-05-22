/* Use the LocationManager class to obtain GPS locations */
LocationManager LM = (LocationManager) getSystemService(LOCATION_SERVICE);
//Gather GPS data at a certain time interval.
LM.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1f, myContext);
//Check to see if GPS is on
boolean isGPS = LM
        .isProviderEnabled(LocationManager.GPS_PROVIDER);

//If its off, request to turn it on.
if (isGPS == false)
{
    //Enable GPS pop-up notification.
    AlertDialog.Builder adb = new AlertDialog.Builder(myContext);

    // set title
    adb.setTitle("Enable GPS?");

    // set dialog message
    adb.setMessage("Enable GPS to get full function from the app.");
    adb.setCancelable(false);

    //Yes Button
    adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            startActivityForResult(
                    new Intent(
                            android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS),
                    0);
        }
    });

    //No Button
    adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    });

    // create GPS Alert [Pop-up]
    AlertDialog alertDialog = adb.create();

    // show it
    alertDialog.show();
}
else
{
    //Added this so when the app gets refreshed it will show the true GPS info status.
    status.setText("GPS Status: Enabled");
}