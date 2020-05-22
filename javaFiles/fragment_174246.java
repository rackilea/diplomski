static final String WORKOUT_STATE = "state";


@Override
public void onSaveInstanceState(Bundle savedInstanceState) {

    // Save the user's current workout state
    savedInstanceState.putInt(WORKOUT_STATE, currentState);


    super.onSaveInstanceState(savedInstanceState);
}