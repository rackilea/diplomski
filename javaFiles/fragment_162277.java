SupportMapFragment mapFragment;

if (mapFragment == null) {
        mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));


        // Check if we were successful in obtaining the map.
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);

            if (mapFragment == null) {

                Toast.makeText(getContext(),"Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            }
        }
    }