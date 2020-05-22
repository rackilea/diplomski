@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState != null) {
        currentState = savedInstanceState.getInt(WORKOUT_STATE);

    } else {

        // Initialize members with default values for a new instance
    }

}