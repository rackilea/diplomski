private static void requestWritePermission(final Context context) 
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.CAMERA)) 
        {
            new AlertDialog.Builder(context).setMessage("This app needs permission to use The phone Camera in order to activate the Scanner")
                    .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override public void onClick(DialogInterface dialog, int which) 
                        { ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA}, 1);}
                    }).show();
        } 
        else 
        {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }