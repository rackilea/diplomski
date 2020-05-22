DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Areas");
databaseReference.orderByChild("cityName").equalTo("City_1").addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
       for(DataSnapshot ds : dataSnapshot.getChildren()){
         String key         = ds.getKey();
         String germanName  = ds.child("GermanName").getValue(String.class);
         String englishName = ds.child("EnglishName").getValue(String.class);
       }
    }
}
@Override
public void onCancelled(DatabaseError databaseError) {
  }
});