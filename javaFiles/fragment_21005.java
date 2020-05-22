private void getData(DataSnapshot dataSnapshot) {
    for(DataSnapshot ds : dataSnapshot.getChildren()) {
        String key = ds.getKey();
        String city = ds.child("city").getValue(String.class);
        String name = ds.child("name").getValue(String.class);
    }
}