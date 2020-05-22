Intent intent = new Intent();
    intent.setAction(Intent.ACTION_SEND);
    intent.setComponent(new ComponentName(
        "com.android.bluetooth",
        "com.android.bluetooth.opp.BluetoothOppLauncherActivity"));
    intent.setType("image/jpeg");

    File file = new File(Environment.getExternalStoragePublicDirectory
            (Environment.DIRECTORY_PICTURES) + "/kitkat.jpg");

    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
    startActivity(intent);