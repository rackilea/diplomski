ValueEventListener eventListener = new ValueEventListener() {
        //Searching the database and adding each to list
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                //adding the key to an arraylist to be referenced when deleting records or passing intents from specific button
                mTaskName.add(ds.getKey());
                String name = ds.child("Name").getValue(String.class);
                String date = ds.child("Date").getValue(String.class);
                id.add(name  + "\n" + date);
                Log.d("TAG", name);
            }
            taskListView.setAdapter(arrayAdapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    database.addListenerForSingleValueEvent(eventListener);