@Override
 public void onSaveInstanceState(Bundle savedInstanceState) {
    super.onSaveInstanceState(savedInstanceState);

    savedInstanceState.putInt(CREATE_KEY, mCreate);
    savedInstanceState.putInt(RESTART_KEY, mRestart);
    savedInstanceState.putInt(START_KEY, mStart);
    savedInstanceState.putInt(RESUME_KEY, mResume);    
 }