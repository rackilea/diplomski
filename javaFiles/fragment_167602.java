Marker marqueur = map.addMarker(new MarkerOptions()
                        .position(
                                new LatLng(Double.parseDouble(latitude),
                                        Double.parseDouble(longitude)))
                        .title(name)
                        .icon(iconDecoded);