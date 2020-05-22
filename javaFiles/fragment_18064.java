map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
        @Override
        public void onCameraChange(CameraPosition arg0) {
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 30));
  }
});