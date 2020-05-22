@Override
public void onSaveInstanceState(Bundle savedInstanceState){
    // Saving variables
    savedInstanceState.putBoolean("isGameFinished", isGameFinished);

    // Call at the end
    super.onSaveInstanceState(savedInstanceState);
}

@Override
public void onRestoreInstanceState(Bundle savedInstanceState){
    // Call at the start
    super.onRestoreInstanceState(savedInstanceState);

    // Retrieve variables
    isGameFinished = savedInstanceState.getBoolean("isGameFinished");
}