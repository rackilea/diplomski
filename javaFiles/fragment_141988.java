public void GetListMap(String data, Complete completeListener){

. . . .

mListener = mShiftReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot child: dataSnapshot.getChildren()) {
            Elements.add(child.getValue(FirebaseData.class));
        }

        completeListener.taskComplete(Elements);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {
            completeListener.taskComplete(null);
        }
    });

}