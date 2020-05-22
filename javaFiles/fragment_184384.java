public int claimedNos=0;

    uDatabase.child(userId).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

           claimedNos = dataSnapshot.child("Claimed").getValue(Integer.class);
            Log.d("TAG","claimed nos in account  :"+claimedNos);
           valueClaimed.setText(String.valueOf(claimedNos));
        }