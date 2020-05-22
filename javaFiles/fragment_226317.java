@Override
protected void onPostExecute(ArrayList<ShopArray> shopArray) {
    super.onPostExecute(shopArray);

    for(ShopArray shopArrayObj : shopArray)
    { 
    double lat = shopArrayObj.geo_lat;
    double lng = shopArrayObj.geo_lng;

    LatLng test = new LatLng(lat, lng);

    gMap.addMarker(new MarkerOptions()
        .position(test));
    }

}