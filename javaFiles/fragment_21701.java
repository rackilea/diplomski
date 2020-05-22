public void restartAudioSpinner() {
    DatabaseReference database;
    database = FirebaseDatabase.getInstance().getReference("Audio Categories");

    database.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            categorylist = new ArrayList<String>();

            for (DataSnapshot data :dataSnapshot.getChildren()) {
                CategoryNew category = data.getValue(CategoryNew.class);
                categoriesList.add(new CategoryNew(category.getImageUrl(),category.getTitle()));
            }

            for (int i = 0; i < categoriesList.size(); i++) {
                categoriesTitle.add(categoriesList.get(i).getTitle());
            }
                 **// PUT THE DESIRED FUNCTION HERE!!!** EX: INIT THE SPINNER
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
}