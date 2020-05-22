public void onRestoreInstanceState(Bundle savedInstanceState) {

    super.onRestoreInstanceState(savedInstanceState);

    // Restore state
    currentScore = savedInstanceState.getInt(WORKOUT_STATE);

}