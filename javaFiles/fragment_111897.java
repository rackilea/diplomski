@Override
    public void onShake() {

        if (count++ >= 1) {
            ConnectionDetector cd = new ConnectionDetector(
                    getApplicationContext());
            isInternetPresent = cd.isConnectingToInternet();
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(1000);
            if (isInternetPresent) {
                createData();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Enable Data Connection", Toast.LENGTH_LONG).show();
            }
        }
    }