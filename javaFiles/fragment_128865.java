databaseReferenceObj2.runTransaction(new Transaction.Handler() {
        @Override
        public Transaction.Result doTransaction(MutableData mutableData) {
            long newValue = 1; // If it doesn't exist, assume zero and increment to 1.
            String currentValue = mutableData.getValue(String.class);
            if (currentValue != null) {
                newValue = Long.parseLong(currentValue) + 1;
            }

            // Set value and report transaction success
            mutableData.setValue(String.valueOf(newValue));
            return Transaction.success(mutableData);
        }

        @Override
        public void onComplete(DatabaseError databaseError, boolean b,
                               DataSnapshot dataSnapshot) {
            // Transaction completed
            Log.d(TAG, "postTransaction:onComplete:" + databaseError);
        }
    });