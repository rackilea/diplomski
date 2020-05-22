DatabaseReference scoresRef = firebaseDatabase.getReference("Highscores").child("GlobalHighScore");
Query q=scoresRef.orderByChild("score").limitToFirst(10);    
q.addValueEventListener(new ValueEventListener() {
    @Override public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot data : dataSnapshot.getChildren()){
          String name=datas.child("name").getValue().toString();
          String score=datas.child("score").getValue().toString();
        }
    }