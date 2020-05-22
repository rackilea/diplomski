mMap.setOnCameraChangeListener(new OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {   
            mMap.clear();               
            mMap.addMarker(new MarkerOptions().position(cameraPosition.target));
        }
});