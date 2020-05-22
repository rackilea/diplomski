myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
             Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
            Log.d(TAG, "Value is: " + map);
        }

        @Override
        public void onCancelled(DatabaseError error) {
            Log.w(TAG, "Failed to read value.", error.toException());
        }
    });