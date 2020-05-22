public  void getFoodItem(String foodNum, final FoodListener listener) {

    dbReference=firebaseDatabase.getReference("Food"+foodNum);

    dbReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            FoodItem foodItem = dataSnapshot.getValue(FoodItem.class);
            Log.d("h", "Gotdata" + foodItem.getImage());

            listener.onFoodReceived(foodItem);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

            listener.onError(databaseError.toException());
        }
    });
}