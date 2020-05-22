map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {

        Restaurants restaurants = places.get(marker);
        Log.d(TAG,"restaurants1"+ restaurants.getName());
        Intent intent = new Intent(MapsActivity.this, RestaurantDetailsActivity.class);
        Log.d(TAG, "lat" + restaurants.getLat());
        Log.d(TAG, "lng" + restaurants.getLng());
        intent.putExtra("id", restaurants.getId());
        intent.putExtra("name", restaurants.getName());
        startActivity(intent);
        }
    });