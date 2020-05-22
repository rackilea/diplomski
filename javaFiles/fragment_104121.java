@Override
protected void onStop() {
    super.onStop();
    if( mAdapter!= null) {
         mAdapter.stopListening();
    }
}