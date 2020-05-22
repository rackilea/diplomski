private void showData(DataSnapshot dataSnapshot) {

   Map<String,Object> map = (Map) dataSnapshot.getValue().child("users").child(userID);
   ArrayList<String> array  = new ArrayList<>();
   for (Map.Entry<String, Object> entry : map.entrySet()) {

      // key contains "Fruit" or "Veg"
      String key = entry.getKey();
      // value is the corresponding list
      Object value = entry.getValue();
      array.addAll((ArrayList) value);

   }
   ArrayAdapter adapter = new 
       ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
   lvProfiles.setAdapter(adapter);

}