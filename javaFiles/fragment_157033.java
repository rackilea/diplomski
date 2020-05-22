@Override
public void onResume(){
    super.onResume();
    // first, check connectivity
    if ( isOnline ){
        // do things if it there's network connection
    }else{
        // as it seems there's no Internet connection
        // ask the user to activate it
        new AlertDialog.Builder(YourActivity.this)
            .setTitle("Connection failed")
            .setMessage("This application requires network access. Please, enable " +
                    "mobile network or Wi-Fi.")
            .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // THIS IS WHAT YOU ARE DOING, Jul
                    YourActivity.this.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    YourActivity.this.finish();
                }
            })
            .show();
    }
}