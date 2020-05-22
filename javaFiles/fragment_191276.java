DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("UserInformation");
 ref.orderByChild("userCRM").equalTo(CRM_value_here).addValueEventListener(new ValueEventListener(){
  @Override
public void onDataChange(DataSnapshot dataSnapshot){
 if(dataSnapshot.exists()){
    Toast.makeText(Activity_Name.this, "Stop!",Toast.LENGTH_LONG).show();
      return;
 }
}
   @Override
  public void onCancelled(FirebaseError firebaseError) {

    }
 });