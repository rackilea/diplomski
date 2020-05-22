@Override
protected void onStop() {
    super.onStop();
    if(FBRA != null) {
        FBRA.stopListening();
    }
}