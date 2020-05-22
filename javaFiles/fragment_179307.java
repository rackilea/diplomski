String text = spinner.getSelectedItem().toString();
 FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
 DatabaseReference currentUserDB2=FirebaseDatabase.getInstance().getReference().child("Cardio").child(user.getUid());
 currentUserDB2.orderByChild("detailCategory").equalTo(text).addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            cardiosList.clear();
            for(DataSnapshot cardioHistorySnapshot : dataSnapshot.getChildren()){

               String category=cardioHistorySnapshot.child("detailCategory").getValue().toString();
                cardiosList.add(category);
            }

            CardioHistoryList adapter = new CardioHistoryList(Cardio_History.this, cardiosList);
            ListViewCardioHistory.setAdapter(adapter);