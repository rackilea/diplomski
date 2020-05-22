DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Users");
ref.orderByChild(username).startAt("jo").endAt("jo\uf8ff").limitToFirst(20).addValueEventListener(new ValueEventListener(){

@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot data: dataSnapshot.getChildren()){
       String usernames=data.getKey();
    }
}

@Override
public void onCancelled(DatabaseError databaseError) {

  }
});