DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Profiles");
 ref.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot datas : dataSnapshot.getChildren()) {
            String key=datas.getKey();
            String name=datas.child("name").getValue().toString();
              }
        }
}