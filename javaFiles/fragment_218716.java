@Override protected void onDetachedFromWindow(){
    super.onDetachedFromWindow();
    if (realmResults.isValid()) {
      realmResult.removeChangeListener(myChangeListener);
    }
}