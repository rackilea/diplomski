databaseReference = firebaseDatabase.getReference("Users/" + firebaseAuth.getInstance().getCurrentUser().getUid());
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        user.setProfileComplete(dataSnapshot.getValue(User.class).getProfileComplete());

        //The profileComplete method returns TRUE, so we can skip the profile creation.
        if(user.getProfileComplete()) {
            Intent intent = new Intent(MainActivity.this, ViewProfileActivity.class);
            startActivity(intent);
        }

        //the profileComplete method returns FALSE, we must send the user to the profile creation.
        else {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d("MainActivity", "COULD NOT RECIEVE PROFILECOMPLETE FROM DATABASE");
    }
});