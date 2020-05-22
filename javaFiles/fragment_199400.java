DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference pi1DetailTestRef = rootRef.child("pi1DetailTest");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String location = ds.child("location").getValue(String.class);
            list.add(location);
            String piId = ds.child("piId").getValue(String.class);
            list.add(piId);
            String pondName = ds.child("pondName").getValue(String.class);
            list.add(pondName);
        }
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
pi1DetailTestRef.addListenerForSingleValueEvent(eventListener);