ActionLockingHelper.unlockIfRequired(Activity, new UnlockEventListener(){
    public void onCanceled(){ } // Dialog was closed without entry
    public void onUnlockFailed(String reason){ } // Not called with default Dialog, instead is handled internally
    public void onUnlockSuccessful(){
        Intent intent = new Intent(LockActivity.this, ShowContentActivity.class);
        startActivity(intent);
    }
});