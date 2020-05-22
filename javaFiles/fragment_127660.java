db.child("Users").orderByChild("username").equalTo(username).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
            //Get the password,and check it against the password field
            Map<String, String> map = (Map<String, String>)snapshot.getValue();

            Log.d("result", map.get("password"));
        }
    }