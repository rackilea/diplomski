Firebase countRef = new Firebase(URL);
Transaction.Handler handler = new Transaction.Handler() {
    @Override
    public Transaction.Result doTransaction(MutableData currentData) {
        // set the new time
        ...
    }

    @Override
    public void onComplete(FirebaseError error, boolean committed, DataSnapshot currentData) {
        if (error != null) {
            ...
        } else {
            if (!committed) {
                ...
            } else {
                // transaction committed, do next iteration
                ...
            }
            ...
        }
    }
});
countRef.runTransaction(handler);