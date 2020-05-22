@Override
protected void onStop() {
    MyActivity.super.onStop(); //Added outside
    db.collection("ABC").document("123").delete().addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {

            db.collection("XYZ").document("123").delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    progressDialog.dismiss();
                    finish();
                }
            });
        }
    });
}