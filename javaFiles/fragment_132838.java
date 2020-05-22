DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Users");
 ref.orderByChild("Phone").equalTo(9988776655).addValueEventListener(new ValueEventListener(){
 @Override
public void onDataChange(DataSnapshot dataSnapshot) { 
   for(DataSnapshot datas: dataSnapshot.getChildren()){
     String keys=datas.getKey();
  }

 @Override
public void onCancelled(FirebaseError firebaseError) {


    }
   });