getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            Log.v("MainTask", "run() Called");
            GpsHelper gpsHelper = new GpsHelper(getApplicationContext(), this); // This is causing the error - commented out => no error
        }
    });