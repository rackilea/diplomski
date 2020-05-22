@Override
protected void onStop() {
    super.onStop();
    if(firestoreRecyclerAdapter != null) {
        firestoreRecyclerAdapter.stopListening();
    }
}