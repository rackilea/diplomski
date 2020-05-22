private OnMapReadyCallback onMapReadyCallback =
        new OnMapReadyCallback() {
   @Override
   public void onMapReady(TomtomMap map) {
      //Map is ready here
      tomtomMap = map;
      tomtomMap.setMyLocationEnabled(true);
   }
};