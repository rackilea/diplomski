final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    //Query query = database.child("exercises");
    //Log.i("Database query", database.child("exercises").toString());
    database.child("exercises").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot exerciseSnapshot: dataSnapshot.getChildren())
            {
                List<ExerciseList> exercises = new ArrayList<ExerciseList>();
                ExerciseList exerciseList = exerciseSnapshot.getValue(ExerciseList.class);
                Log.i("description/name", exerciseList.getDescription() + " " + exerciseList.getName());
                exercises.add(exerciseList);

            }
               adapter = new ExerciseLoadListAdapter(mActivity, exercises);
               mListView.setAdapter(adapter)
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });