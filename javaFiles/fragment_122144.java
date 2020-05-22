mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

        @Override
        public void onMapLongClick(LatLng arg0) {

            Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
            try {
                List<Address> allAddresses = geocoder.getFromLocation(arg0.latitude, arg0.longitude, 1);
                  if (allAddresses.size() > 0) {
                    Address address = allAddresses.get(0);

                     Intent intent = new Intent(getActivity(), LocationDetailsActivity.class);
                     intent.putExtra("latitude", arg0.latitude);
                     intent.putExtra("longitude", arg0.longitude);
                     intent.putExtra("city", allAddresses.get(0).getLocality());
                     intent.putExtra("zip", allAddresses.get(0).getPostalCode());
                     intent.putExtra("state", allAddresses.get(0).getAdminArea());
                     intent.putExtra("country", allAddresses.get(0).getCountryName());
                     startActivity(intent);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });