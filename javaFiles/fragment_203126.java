database.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    if (dataSnapshot.exists()) {
        Toast.makeText(getApplicationContext(), "it exists.", Toast.LENGTH_SHORT).show();
    }
    else {
        Toast.makeText(getApplicationContext(), "it's OK.", Toast.LENGTH_SHORT).show();
    }
}