AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Custom Sharing Dialog");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                ResolveInfo info = activities.get(item);

                if (info.activityInfo.packageName.equals("com.facebook.katana")) {
                    Toast.makeText(activity, "Facebook Selected ", Toast.LENGTH_LONG).show();
                } else {

                    // start the selected activity
                    Log.i(TAG, "Hi..hello. Intent is selected");
                    intent.setPackage(info.activityInfo.packageName);
                    startActivity(intent);
                }
            }
        });

AlertDialog alert = builder.create();
alert.show();