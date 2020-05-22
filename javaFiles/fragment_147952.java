public void getAllRestaurant(){
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            List<RestaurantModel> listRestaurant = new ArrayList<>();

            for (DataSnapshot valueRes : dataSnapshot.getChildren()){
                RestaurantModel restaurantModel = valueRes.getValue(RestaurantModel.class);
                Log.d("Test", restaurantModel.getRestaurantName());
                listRestaurant.add(restaurantModel);
            }

            //Do what you need to do with listRes
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            throw databaseError.toException();
        }
    };
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();        
    rootRef.child("restaurants").addListenerForSingleValueEvent(valueEventListener);
}