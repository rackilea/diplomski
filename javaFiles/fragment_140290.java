Snackbar.make(activity, R.string.rationaleStringId, Snackbar.LENGTH_INDEFINITE)
          .setAction(android.R.string.ok, new View.OnClickListener() {
            @Override
            @TargetApi(Build.VERSION_CODES.M)
            public void onClick(View v) {
                 ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.READ_SMS}, MY_PERMISSIONS_REQUEST_READ_SMS);
            }
          }).show();