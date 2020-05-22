Query query = FirebaseDatabase.getInstance().getReference().child("account").orderByChild("username").equalTo(username);

ValueEventListener valueEventListener = new ValueEventListener() { 
    @Override 
    public void onDataChange(DataSnapshot dataSnapshot) { 
        if (dataSnapshot.getValue() != null && dataSnapshot.getChildrenCount() > 0) {
           for (DataSnapshot data : dataSnapshot.getChildren()) {

                // I'm sure you are looking for below line.. Go and try this.
                if (data.child("username").getValue().toString().equal(username) ) {
                  getted = "yes";
                  break;
                } else {
                  getted = "No";
                }
           }
        } else {
            getted = No value available;
        }
        Toast.makeText(getApplicationContext(), "getted : " + getted, Toast.LENGTH_LONG).show();
    } 

    @Override 
    public void onCancelled(DatabaseError databaseError) { 
        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show(); 
    } 
};