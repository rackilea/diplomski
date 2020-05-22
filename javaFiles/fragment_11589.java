games.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
        HomePage.getCurrentGameID(new HomePage.CallbackID() {
            @Override
            public void onSuccess(final String currentGameID) {
                if (dataSnapshot.child(currentGameID.child("ready").getValue().equals(true))) {
                runCounter();
                    Log.i("FlipCoin", "``ButtonClickListener happened");
                }
            }
        });

        games.removeEventListener(this); //remove it here
    }
});