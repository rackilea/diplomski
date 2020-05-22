class MyGeoListener extends GeoQueryEventListener{

    private ArrayList<String> keysGeolocated;

    MyGeoListener(ArrayList<String> keysGeolocated){
          this.keysGeolocated = keysGeolocated;
    }

    @Override
    public void onKeyEntered(String key, GeoLocation location) {
        keysGeolocated.add(key);
        System.out.println("1111111111 : "+keysGeolocated);
        System.out.println("2222222222 : "+key);
    }

    @Override
    public void onKeyExited(String key) {

    }

    @Override
    public void onKeyMoved(String key, GeoLocation location) {

    }

    @Override
    public void onGeoQueryReady() {

    }

    @Override
    public void onGeoQueryError(DatabaseError error) {

    }
}