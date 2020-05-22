DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ingridientsRef = rootRef.child("Receptes").child("Ingridients");
ValueEventListener valueEventListener = new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot ds : dataSnapshot.getChildren()) {
          Boolean carrot = (Boolean) ds.child("Carrot").getValue();
        //etc
        Log.d("TAG", ingridient);
    }
}

   @Override
public void onCancelled(DatabaseError databaseError) {}
  };
ingridientsRef.addListenerForSingleValueEvent(valueEventListener);