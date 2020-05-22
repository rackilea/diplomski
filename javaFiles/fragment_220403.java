MarkerOptions optionss = new MarkerOptions()
                    .alpha(1)
                    .flat(false)
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin));
            googleMap.addMarker(optionss);