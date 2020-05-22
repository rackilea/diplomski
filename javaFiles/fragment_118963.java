idcheckbtn.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
    sid = id.getText().toString().trim();

    // No need to store the id user created
    // FirebaseDatabase.getInstance().getReference().child("users").child("id").setValue("add");

    FirebaseDatabase.getInstance().getReference().child(sid).addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                // sid already exists
            } else {
                // sid does not exists already
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}
});