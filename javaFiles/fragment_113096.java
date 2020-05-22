@Override
protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    mAdapter.closeDatabase();   
}

@Override
protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
    mAdapter.openDatabase();
}