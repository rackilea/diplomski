ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        List<RestaurantModel> listRes = new ArrayList<>();

        for (DataSnapshot dataValues : dataSnapshot.getChildren()){
            RestaurantModel restaurantModel = dataValues.getValue(RestaurantModel.class);
            listRes.add(restaurantModel);
        }

        //Do what you need to do with listRes
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException(); //Don't ignore errors
    }
};
dataResReference.addListenerForSingleValueEvent(valueEventListener);