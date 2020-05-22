@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    // Save the datas
    savedInstanceState.putString("SAVED_LOGINID", getIntent().getExtras().getString("LOGINID"));
    savedInstanceState.putInt("SAVED_ROLE", getIntent().getExtras().getInt("ROLE"));

    // Always call the superclass so it can save the view hierarchy state
    super.onSaveInstanceState(savedInstanceState);
}