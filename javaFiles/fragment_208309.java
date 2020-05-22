@Override
protected void onStart() {
super.onStart();
DatabaseReference mDatabase;
mDatabase = FirebaseDatabase.getInstance().getReference();
Transaction payment=new Transaction("merchant","user","1000","live");
mDatabase.child("transctions").child("2").setValue(payment);
}