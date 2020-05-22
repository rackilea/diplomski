mMap.setOnCameraChangeListener(new OnCameraChangeListener() {

        @Override
        public void onCameraChange(CameraPosition cameraPosition) {
            mClusterManager.onCameraChange(cameraPosition);

            // Your custom code here

        }
    });