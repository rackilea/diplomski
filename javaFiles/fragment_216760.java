@Override
    public void onDataChange(@NonNull DataSnapshot 
    dataSnapshot) {
    int sum=0;
    for (DataSnapshot ds1:dataSnapshot.getChildren()){
        int a=ds1.child("profit").getValue(Integer.class);
        sum+=b;
       int i = sum;
      String value = String.valueOf(i);
      Toast.makeText(RecordsActivity.this, value, 
      Toast .LENGTH_SHORT).show();
       }

       }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

}