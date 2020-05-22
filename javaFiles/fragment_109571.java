private void addPolygonsToMap(GoogleMap googleMap) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference pProfileRef = db.collection("polygons");
        pProfileRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        List<Object> polyPoint=(List<Object>)document.get("points");
                                int length = polyPoint.size();
                                if (length == 0) {
                                    return;
                                }
                                PolygonOptions poly = new PolygonOptions();
                                poly.fillColor(0x4d4fa5d5);
                                for (int i = 0; i < length; i++) {
                                    GeoPoint polyGeo = (GeoPoint) polyPoint.get(i);
                                    double lat = polyGeo.getLatitude();
                                    double lng = polyGeo.getLongitude ();
                                    LatLng latLng = new LatLng(lat, lng);
                                    poly.add(latLng);
                                }
                                googleMap.addPolygon(poly);
                    }
                } else {
                    Log.d(TAG, "Error getting documents:", task.getException());
                }
            }
        });
    }