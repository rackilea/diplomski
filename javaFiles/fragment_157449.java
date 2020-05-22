private void storeLocation(com.wfs.android.walkingjinni.Location location) {
    com.wfs.android.walkingjinni.Location loc = new com.wfs.android.walkingjinni.Location(

            mFirebaseUserId,
            location.getName(),
            location.getAddress(),
            location.getLatitude(), location.getLongitude()
            ,location.getPlaceId());

    mFirebaseDatabaseReference
            .child(PlacesFragment.USERS_CHILD).child(mFirebaseUserId)
            .child(PlacesFragment.LOCATIONS_CHILD).push().setValue(loc);

    Log.d(TAG, location.getAddress() + " stored from map");

}