@Override
public void onSaveInstanceState (Bundle outState) {
    // TODO Auto-generated method stub
    super.onSaveInstanceState(outState);
    outState.putSerializable("array", arrayDetails);
}