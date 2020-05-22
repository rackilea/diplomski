FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
CollectionReference pointsRef = rootRef.collection("points_au");
DocumentReference parkRef = pointsRef.document("Park");
parkRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document.exists()) {
                GeoPoint geo = document.getGeoPoint("geo");
                String name = document.getString("name");
                double lat = geo.getLatitude();
                double lng = geo.getLongitude();
                LatLng latLng = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions().position(latLng).title(name));
            }
        }
    }
});