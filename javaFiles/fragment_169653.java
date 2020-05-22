ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> arrayList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Question question = ds.getValue(Question.class);
            arrayList.add(question.title);
        }

        //Do what you need to do with your arrayList
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
refQuestions.addListenerForSingleValueEvent(valueEventListener);