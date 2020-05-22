mMessageDatabase.child(User1).child(User2).addListenerForSingleValueEvent(new ValueEventListener() {

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot != null) {
           for(DataSnapshot datas: dataSnapshot.getChildren()){

            String message = datas.child("message").getValue(String.class);
            Log.e(TAG, "CHAT_LOG: " + message);
           }
        }
    }