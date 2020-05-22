if (task.isSuccessful()) {
    boolean b = task.getResult().isEmpty();
    ToastEX.showShort( MainActivity.this, b ? "isLocked=1" : "isLocked=0");
}  else {
    Log.d(TAG, "Error getting documents: ", task.getException());
}