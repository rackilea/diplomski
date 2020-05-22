@Override
protected void onStop() {
    super.onStop();
    if (adapter != null) {
        adapter.stopListening();
    }
}