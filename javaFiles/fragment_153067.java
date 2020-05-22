mDatabase.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int i = 0;
        for (DataSnapshot d : dataSnapshot.getChildren()) {
            key[i] = d.getKey();
            i++;
        }
        for (int counter = key.length - 1; counter >= 0; counter--) {
            viewHolder.setUpDate(first + "/" + key[counter]);
            mDatabase.child(key[counter]).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    StringBuilder builder = new StringBuilder();
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        builder.append(child.getKey().toString() + "\n\n");

                    }
                    viewHolder.setName(builder.toString());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    throw databaseError.toException(); // don't ignore errors        
                }
            });
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
});