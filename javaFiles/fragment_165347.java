public void addNewUser(String someInput, final FooOnSuccessListener listener){

    mFirebaseFirestore.collection("users").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
        @Override
        public void onSuccess(DocumentReference documentReference) {
            listener.iWantToPassOutAnInteger(FromYourFirebase.someInteger);
        }
    });

}