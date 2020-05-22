FirebaseUser currentuser=FirebaseAuth.getInstance().getCurrentUser();

ref.orderByKey().equalTo(currentuser.getUid()).addValueEventListener(new ValueEventListener(){

 //like above

   }