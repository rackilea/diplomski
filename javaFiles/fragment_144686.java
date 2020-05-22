// Inside the class itself
private boolean hasSelected = false;

public void onClick(View v) {

    SharedPreferences.Editor editorWorkout = workoutPref.edit();

    // get the constraint layout from its ID.
    ConstraintLayout mConstraintLayout = getView().findViewById(R.id.FragmentWorkoutMood1);

    switch (v.getId()) {
        case R.id.excitedFace:
            mConstraintLayout.setBackgroundResource(R.mipmap.background_clouds_excited);
            editorWorkout.putInt("excitedkey", EXCITED.getId());
            editorWorkout.commit();
            hasSelected = true;
            break;
        case R.id.happyFace:
            mConstraintLayout.setBackgroundResource(R.mipmap.background_clouds_happy);
            editorWorkout.putInt("happykey", HAPPY.getId());
            editorWorkout.commit();
            hasSelected = true;
            break;
        case R.id.fineFace:
            mConstraintLayout.setBackgroundResource(R.mipmap.background_clouds_fine);
            editorWorkout.putInt("finekey", FINE.getId());
            editorWorkout.commit();
            hasSelected = true;
            break;
        case R.id.nextBtnMoodPage:
            if(hasSelected){
                Intent intent = new Intent(getActivity(),   WorkoutAutomaticThoughtActivity.class);
                startActivity(intent);
            }
    }
}