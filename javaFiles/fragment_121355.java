getActivity().runOnUiThread(new Runnable() {
    @Override
    public void run() {
        map.clear();
        for(int index = 0; index < name.size(); index++) {
            try {
                LatLng point = new LatLng(Double.parseDouble(lat.get(index)), Double.parseDouble(latlong.get(index)));
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(point)
                        .title(name.get(index))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_pin));
                marker = map.addMarker(markerOptions);
                markers.add(marker);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
});