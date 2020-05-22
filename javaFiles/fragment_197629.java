rootref.child("messeges").child(YourInnerChildKey).addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
      int count = 0;
      String firstNodeId;
      for (DataSnapshot ds : dataSnapshot.getChildren()) {
        if (count == 0) firstNodeId = ds.getKey();
        count++;
      }

      if(count > 10){
         rootref.child("messeges").child(YourInnerChildKey).removeEventListener(this);
         firebase.child(firstNodeId).removeValue();
         rootref.child("messeges").child(YourInnerChildKey).addValueEventListener(this);
      }
}