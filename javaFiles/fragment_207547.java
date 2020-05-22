ref.child("-LiCZpsymgNgtNcCinpHR5").child("petname").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        try {
            if (snapshot.getValue() != null) {
                try {
                    Log.e("TAG", "" + snapshot.getValue()); // your name values you will get here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("TAG", " it's null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        Log.e("onCancelled", " cancelled");
    }
});