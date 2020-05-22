@Override
public void onSaveInstanceState(Bundle outState) {
    outState.putString("KeyForReturning", mSelectedView.getText());

    // call superclass to save any view hierarchy
    super.onSaveInstanceState(outState);
}



if(savedInstanceState != null){
  String myValue = savedInstanceState.getString("KeyForReturning");
  if(myValue != null){
    mSelectedView.setText(myValue);
  }
}