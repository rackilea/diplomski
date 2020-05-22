DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(registeredUser);
 DatabaseReference nameRef = ref.child(month);

NameRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){

            String name=postSnapshot.getKey();
            customerArray.add(name);
            adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, customerArray);
            customerList.setAdapter(adapter);
        }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

        Log.w("name","load:onCancelled",databaseError.toException());

    }
});