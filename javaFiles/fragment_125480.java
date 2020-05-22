@Override
protected void onCreate() {
    // Other code

    MapFragment mapFrag = new MapFragment();
    // Now register your fragment as the listener
    mRequestingLocationUpdates = mapFrag;

    // Other code.. 
}