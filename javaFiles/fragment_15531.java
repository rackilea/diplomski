private SpeedHelper.Listener mCallSpeedListener = new SpeedHelper.Listener() {

        @Override
        public void OnSelected(String entry) {
            Toast.makeText(getApplicationContext(), entry, Toast.LENGTH_SHORT).show();
        }
    };