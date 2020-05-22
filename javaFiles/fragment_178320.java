String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference hasilRef = rootRef.child("User").child(uid).child("HasilLab");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String imageUri = dataSnapshot.child("imageUri").getValue(String.class);
        String keterangan = dataSnapshot.child("keterangan_HasileLab").getValue(String.class);
        String nama = dataSnapshot.child("nama_Hasil_Lab").getValue(String.class);
        Log.d("TAG", imageUri + " / " + keterangan + " / " + nama);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
hasilRef.addListenerForSingleValueEvent(valueEventListener);