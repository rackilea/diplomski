public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            MapFragment mf = new MapFragment();
            MapFragment.googleMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble("2.900000"), Double.parseDouble("1.55555")))
            .title("oh yeah"));//move this to the end
            ft.add(R.id.maps_layout, mf);
            ft.commit();
           //here you add your marker
        }