LatLngBounds mapBounds;
for (DataItem location : mUserLocations.keySet()) {
    if (mapBounds==null) {
        LatLng point = new LatLng(Double.parseDouble(location.mData.get("latitude")), Double.parseDouble(location.mData.get("longitude")))
        mapBounds =new LatLngBounds(point, point);
    } else {
        mapBounds = mapBounds.including(new LatLng(Double.parseDouble(location.mData.get("latitude")), Double.parseDouble(location.mData.get("longitude"))));
    }
}