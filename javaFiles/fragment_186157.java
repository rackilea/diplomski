public void loadScoresFromFireBase() {
    String entry = "";
    for (int i = 0; i < 10; i++) {
        entry = "Name_" + i;
        myFirebase.child("users").child(entry).addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                scores.add(snapshot.getValue(Score.class));
                Collections.sort(scores);
                Intent intent = new Intent(getApplicationContext(), ScoreBoard.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("players", scores);
                intent.putExtra("players", bundle);
                startActivityForResult(intent, 0);
            }
            public void onCancelled(FirebaseError firebaseError) { }
        });

    }
}
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    //....
    if (id == 2) {
        loadScoresFromFireBase();