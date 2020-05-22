valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                String name = snapshot.child("name").getValue(String.class);
                String specialty = snapshot.child("specialty").getValue(String.class);
                String thumbnail = snapshot.child("thumbnail").getValue(String.class);
                String id = snapshot.getKey();
                Doctors doctor = new Doctors(id,name, specialty,thumbnail);
                list.add(doctor);
                adapter.notifyDataSetChanged();
            }
        }