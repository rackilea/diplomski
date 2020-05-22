DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference patientRef = rootRef.child("patient");

ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String mobileNumber = ds.getKey();

            DatabaseReference mobileNumberRef = patientRef.child("mobileNumber");
            Query query = mobileNumberRef.orderByChild("dates").equalTo(date);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
                        String name = dSnapshot.child("name").getValue(String.class);
                        Log.d("TAG", name);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            query.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
patientRef.addListenerForSingleValueEvent(valueEventListener);