setContentView(R.layout.main_screen);

SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);

if(googleServicesAvailable() && mapFragment != null){
    mapFragment.getMapAsync(this); 
} else {
    // No Google Play Services
}