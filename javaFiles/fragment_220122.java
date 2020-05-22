DatabaseReference myRef = database.getReference("My Words");
TextView englishView, arabicView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.displaying);
    readData();
}
private void readData() {
    englishView = findViewById(R.id.textView);
    arabicView = findViewById(R.id.arabicView1);
    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                MyWords words = postSnapshot.getValue(MyWords.class);

                //here you were overwritting the content of the textbox everytime.
                englishView.setText( englishView.getText()+" "+ words.getEnglish());
                arabicView.setText(arabicView.getText()+" " +words.getArabic());
            }
        }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.d("TAG" , databaseError.getMessage());
        }
    });
}