// Ask for the read external storage permission
if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
{
    // Should we show an explanation?
    if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE))
    {
        // Provide an additional rationale to the user if the permission was not granted
        // and the user would benefit from additional context for the use of the permission.
        // Display a SnackBar with a button to request the missing permission.
        Snackbar.make(layout,
                    "External storage is needed in order to {YOUR EXPLANATION HERE}",
                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    // Request the permission
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
                }
            }).show();
        }
        else
        {
            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
}