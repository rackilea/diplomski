private HashMap<Marker, Integer> markerIdMapping = new HashMap<>();


 private void addMarker(LatLng latlng, final String title, final String deskripsi, final String id) {
        markerOptions.position(latlng);
        markerOptions.title(title);
        markerOptions.snippet(deskripsi);

        Marker marker = gMap.addMarker(markerOptions);
        markerIdMapping.put(marker, id);

        gMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                String markerId = markerIdMapping.get(marker);
            }
        });
    }