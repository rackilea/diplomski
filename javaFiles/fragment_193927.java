System.out.println("Before starting get()");
db.collection("users").document(UID).collection("animals").
document(animalId).get().addOnCompleteListener(new 
OnCompleteListener<DocumentSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
        System.out.println("In onComplete()");
    }
});
System.out.println("After starting get()");