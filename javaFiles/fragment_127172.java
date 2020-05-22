dbref = FirebaseDatabase.getInstance().getReference();
Query lastSession = dbref.child("data").orderByKey().limitToLast(1);

lastSession.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
    for (DataSnapshot keyNode : dataSnapshot.getChildren()){
        for (DataSnapshot ds : keyNode.getChildren()){
            keys.add(ds.getKey());
            Reading reading = ds.getValue(Reading.class);
            readings.add(reading);

        }
    }