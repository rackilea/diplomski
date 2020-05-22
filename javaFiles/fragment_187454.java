DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference newRef = rootRef.child("new");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.child("mailID").getChildren()) {
            MailId mailId = ds.getValue(MailId.class);
            Log.d("TAG", mailId.email + " / " + mailId.name);
        }
        for(DataSnapshot ds : dataSnapshot.child("mailText").getChildren()) {
            MailText mailText = ds.getValue(MailText.class);
            Log.d("TAG", mailText.subject + " / " + mailText.title);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
newRef.addListenerForSingleValueEvent(valueEventListener);