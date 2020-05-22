DatabaseReference root =FirebaseDatabase.getInstance().getReference();
DatabaseReference user = 
root.child("myDatabase").child("messages").child("CharlesDoe");
user.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot snapshot) {
    if (snapshot.exists()) {
        // run some code
    }else{
    Toast.makeText(this,"no messages",Toast.Length_LONG).show();

    }
}

@Override
public void onCancelled(DatabaseError databaseError) {

}
});