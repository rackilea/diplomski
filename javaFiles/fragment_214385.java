mRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            try {
                for(DataSnapshot snap :  dataSnapshot.getChildren())
                RecipeModel rm = snap.getValue(RecipeModel.class);
                String name =rm.getName();
                String name =rm.getAppetizer();
                  //and then just create a new variable likes in your POJO
                 String likes = rm.getLikes();

     //and then do whatever you want with the data, remember that forEach will iterate through all the recipes for each user, and then you can get any field inside your users
}
            }catch (Exception ex){
               // Toast.makeText(FacultiesActivity.this, ex.toString(), Toast.LENGTH_LONG).show();

            }
        }

        @Override
        public void onCancelled(DatabaseError error) {
            Toast.makeText(FacultiesActivity.this, "Error", Toast.LENGTH_LONG).
 });