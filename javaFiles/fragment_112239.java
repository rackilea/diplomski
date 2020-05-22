day.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
int value = dataSnapshot.getValue(int.class);
textViewDataGet = value;

}

@Override
public void onCancelled(DatabaseError databaseError) {

}
});