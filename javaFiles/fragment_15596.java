List<Restaurant> restaurantList = new ArrayList();



for(int i = 0; i < restaurantList .size(); i++){

    String title = restaurantList.get(i).getName();

    mMap.addMarker(new MarkerOptions().position(new LatLng(restaurantList.get(i).getLat(), restaurantList.get(i).getLang()))
            .title(title));

}