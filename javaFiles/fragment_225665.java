@Override
protected void onStart() {
    super.onStart();
    firebaseRecyclerAdapter.startListening();
}

@Override
protected void onStop() {
    super.onStop();
    if(firebaseRecyclerAdapter != null) {
        firebaseRecyclerAdapter.stopListening();
    }
}