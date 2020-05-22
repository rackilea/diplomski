public void loadScoresFromFireBase() {
    String entry = "";
    for (int i = 0; i < 10; i++) {
        entry = "Name_" + i;
        myFirebase.child("users").child(entry).addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("Adding score to array");
                scores.add(snapshot.getValue(Score.class));
            }
            public void onCancelled(FirebaseError firebaseError) { }
        });

    }
}
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    //....
    if (id == 2) {
        Intent intent = new Intent(getApplicationContext(), ScoreBoard.class);
        Bundle bundle = new Bundle();
        System.out.println("Before calling loadScores");
        loadScoresFromFireBase();
        System.out.println("After calling loadScores");
        Collections.sort(scores);
        System.out.println("After sorting scores");