@Override protected void onStart(){
  super.onStart();
  invalidateOptionsMenu();
  mAdapter.registerDataSetObserver(dataObserver);
}

@Override protected void onStop(){
  mAdapter.unregisterDataSetObserver(dataObserver);
  super.onStop();
}

private final DataSetObserver dataObserver = new DataSetObserver(){
  @Override public void onChanged(){
    invalidateOptionsMenu();
  }
  @Override public void onInvalidated(){
    invalidateOptionsMenu();
  }
};