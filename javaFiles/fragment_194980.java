private BroadcastReceiver createMapReceiver(MapEntry entry) {
        return new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                downloadingDialog.dismiss();
                unregisterReceiver(this);

                ...

                receiveDownloadedFile(new File(completeFilePath), entry);
            }
        };
    }



private void receiveDownloadedFile(File downloadedFile, MapEntry entry) {

   downloadingDialog.setMessage("TEST MESSAGE");

   ...

}