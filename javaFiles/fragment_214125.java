private GoogleMap getGoogleMap() {
        if (map == null && getActivity() != null && getActivity().getSupportFragmentManager()!= null) {
            SupportMapFragment smf = (SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.mapview);
            if (smf != null) {
                map = smf.getMap();
            }
        }
        return map;
    }