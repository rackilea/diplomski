addReference.child("DataInputManual").child(key).child("id_data").setValue(key)
    .addOnSuccessListener(new OnSuccessListener<Void>() {
        @Override
        public void onSuccess(Void aVoid) {
            //Do what you need to do
        }
    });