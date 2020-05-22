private int saved_selection = -1

@Override
protected void onCreate(Bundle savedInstanceState) {
    //...

    if (savedInstanceState != null) {
        saved_selection = savedInstanceState.getInt("SPINNER_SELECTION");
    }

    //...
}

@Override
public void onSaveInstanceState(Bundle outState) {
    outState.putInt("SPINNER_SELECTION", saved_selection);

    // call superclass to save any view hierarchy
    super.onSaveInstanceState(outState);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    //...
    // set `saved_selection = i;`  in your adapter
    //...
    if( saved_selection >= 0 ) {
        mSpinner.setSelection(saved_selection);
    }
}