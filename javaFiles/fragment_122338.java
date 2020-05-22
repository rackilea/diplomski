public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    mVenues.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot s : dataSnapshot.getChildren()){
                Venue venue = s.getValue(Venue.class);

                venueList.add(venue);
                for (int i = 0; i < venueList.size(); i++)
                {
                    LatLng latLng = new LatLng(venue.venueLat,venue.venueLong);
                    if (mMap != null) {
                        marker = mMap.addMarker(new MarkerOptions().position(latLng).title(venue.venueName));
                                            }
                }
            }

        }