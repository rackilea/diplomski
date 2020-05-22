public void searchemail(String email){

  Firebase ref = new Firebase("https://<myfirebase>.firebaseio.com/users");
  Query queryRef = ref.orderByChild("Email").equalTo(email);


   ValueEventListener listener = new ValueEventListener() {

     @Override
     public void onDataChanged(DataSnapshot snapshot) {
       if (snapshot.exists()) {
         for (DataSnapshot child: snapshot.getChildren()) {
           homeintent.putExtra("key", child.getKey());
           startActivity(homeintent);
           break; // exit for loop, we only want one match
         }
       }
       else {
         Toast toast = Toast.makeText(this, "email not found", Toast.LENGTH_SHORT);
       }
     }
   };
   queryRef.addValueEventListener(listener);
}