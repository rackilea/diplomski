final FirebaseDatabase database = FirebaseDatabase.getInstance();
final DatabaseReference ref = database.getReference();

final Spinner stateSpinner = v.findViewById(R.id.state_spinner);

final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
stateSpinner.setAdapter(adapter);

ref.child("stateDescriptions").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int length = (int)dataSnapshot.getChildrenCount();
        adapter.clear();
        for(int i = 0;i<length;i++) {
            adapter.add(dataSnapshot.child(Integer.toString(i)).getValue(String.class));
        }
        // For example, but this sets it back whenever data is added to Firebase 
        stateSpinner.setSelection(1);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // TODO: Implement error handling 
    }
});

stateSpinner.setOnItemSelectedListener( ....