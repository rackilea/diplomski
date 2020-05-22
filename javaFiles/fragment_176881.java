addReference.child("DataInputManual").child(key).child("id_data").setValue(key)
    .addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            if (task.isSuccessful()) {
                //Do what you need to do
            } else {
                Log.d(TAG, task.getException().getMessage());
            }
        }
    });