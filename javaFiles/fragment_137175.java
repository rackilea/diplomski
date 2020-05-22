System.out.println("Before attaching listener");
docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        System.out.println("Got document");
    }
});
System.out.println("After attaching listener");