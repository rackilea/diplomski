new CreateLockDialogBuilder(Activity, 
    new LockCreationListener(){
        public void onLockCanceled(){ } // Dialog was closed without entry
        public void onLockSuccessful(){
            // They've created a PIN, so now you can use the unlocking mechanisms
            doSomethingOnAppLocked();
        }
    })
    .show();