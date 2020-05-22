Marker marker = map.addMarker(new MarkerOptions().position(position)
                        .title(venuesfound.get(i).getName())
                        .snippet("\nOpen: " + venuesfound.get(i).getOpenNow()
                                + "\n(" + venuesfound.get(i).getCategory() + ")")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.measle_blue)));
                markerPlaces.add(marker.getId());