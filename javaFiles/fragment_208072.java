GoogleMap googleMap;

    @Override
    public void onResume() {
     super.onResume();

     if(googleMap != null){
        googleMap.clear();

        // add the markers just like how you did the first time
     }
    }