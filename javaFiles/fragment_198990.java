private final String TRIGGER_REBIRTH = "trigger_rebirth";

@Override
protected void onCreate(Bundle savedInstanceState) {
  if (savedInstanceState != null) {
     if (savedInstanceState.getBoolean(TRIGGER_REBIRTH, false)) {
        // Trigger app restart here
        // See Implementation - https://github.com/JakeWharton/ProcessPhoenix
        ProcessPhoenix.triggerRebirth(this, getIntent());
     }
  }
}

@Override
public void onSaveInstanceState(Bundle outState) {
  outState.putBoolean(TRIGGER_REBIRTH, true);
}