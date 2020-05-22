final ImageButton btnSend = (ImageButton) convertView.findViewById(R.id.btnSend);
btnSend.setTag(new File(strPath)); // btn knows which file is related to it
btnSend.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        File newFile = (File) btnSend.getTag(); // get the related file on click

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setComponent(new ComponentName(
            "com.android.bluetooth",
            "com.android.bluetooth.opp.BluetoothOppLauncherActivity"));
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(newFile)); // use it
        startActivity(intent);

    }
});