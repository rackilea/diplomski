d1.addValueEventListener(new ValueEventListener() {
 @Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
   dvalue1=dataSnapshot.child(name11).child(daystring).child(timestring1).getValue().toString().trim();
   dvalue2=dataSnapshot.child(name12).child(daystring).child(timestring1).getValue().toString().trim();
   if(dvalue1.equals("no class"))
    {
        a=0;
    }

    else 
    {
        a=1;
    }
    if(dvalue2.equals("no class"))
    {
        b=0;
    }
    else
    {
        b=1;
     }
   }
 @Override
public void onCancelled(@NonNull DatabaseError databaseError) {
 Log.d(TAG, "Failed to read value.");
  }
});