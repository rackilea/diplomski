jSettingsDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
...
jSettingsDatabase.addValueEventListener(new ValueEventListener() {
   @Override
   public void onDataChange(DataSnapshot dataSnapshot) {
      for(DataSnapshot node : dataSnapshot.getChildren()) {
         // you will get all cities
         String stgUserHomeName = node.getKey();
         if(!"Washington".equals(stgUserHomeName)) // or whatever city you need
            continue;
         // add some more conditional logic to cope with the distinct subtrees that don't have the same properties
         // London's Resident has more properties than Washington --> exception is thrown then
         // to get the resident's data
         node.child("Resident").child(userId).child("address")...
         node.child("Resident").child(userId).child("image")...
         // or
         node.child("Resident").child(userId).getValue(Resident.class);
         ...
      }
      ....
   }
});