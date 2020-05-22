UUID workoutId = (UUID) 
    getIntent().getSerializableExtra(EXTRA_WORKOUT_ID);

    Log.d("createFragment UUID", workoutId.toString());
    if(workoutId==idOfWorkoutFragment1){
       return WorkoutFragment1.newInstance();
    }else if(...){
    ....
    ....
    }