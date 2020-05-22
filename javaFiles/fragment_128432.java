mostafa.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    String email = dataSnapshot.getValue(String.class);

    display.setText(email);
}

@Override
public void onCancelled(DatabaseError databaseError) {

}
});