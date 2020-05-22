Rider rider = dataSnapshot.getValue(Rider.class);

                        mMap.addMarker(new MarkerOptions()
                                .position(new LatLng(location.latitude, location.longitude))
                                .flat(true)
                                .title(rider.getName())
                                .snippet("Phone: " + rider.getPhone())
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.car)));