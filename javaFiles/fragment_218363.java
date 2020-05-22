DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("County").child("Dublin").child("contacts");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        ArrayList<String> names= new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.child("name").getValue(String.class);
            names.add(name);
            String number = ds.child("number").getValue(String.class);
            Log.d("TAG", name + " / " + number);
        }
        for(String name : names) {
            TextView stringTextView = (TextView) findViewById(R.id.string_text_view);
            stringTextView.setText(stringTextView.getText().toString() + name + " , ");
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
ref.addListenerForSingleValueEvent(eventListener);