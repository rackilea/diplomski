searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { 
  @Override
public void onFocusChange(View v, boolean hasFocus) {
    // Toggle isHideMenuState when search widget has focus/no focus 
        isHideMenuState = hasFocus  
    //Tell menu to re-create itself
    invalidateOptionsMenu(); // onCreateOptionsMenu(...) is called again
    }         
 });