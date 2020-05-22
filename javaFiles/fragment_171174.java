@Override
public void onDataChange(DataSnapshot dataSnapshot) {

    for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {

        ....
    }

    if(mMap != null) {
        for (LatLng point : latlngs) {
            options.position(point);
            options.title("Users");
            options.snippet("someDesc");
            mMap.addMarker(options);
        }
    }
}