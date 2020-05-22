DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference productIdsRef = rootRef.child("productIds");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> productIdsList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String productId = ds.getKey();
            productIdsList.add(productId);
        }

        int productListSize = productList.size();
        List<String> randomProductList = new ArrayList<>(););

        DatabaseReference productIdRef = rootRef.child("products").child(productIdsList.get(new Random().nextInt(int productListSize));
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue(String.class);
                Log.d("TAG", name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "Error: ", task.getException()); //Don't ignore errors!
            }
        };
        productIdRef.addListenerForSingleValueEvent(eventListener);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG, "Error: ", task.getException()); //Don't ignore errors!
    }
};
productIdsRef.addListenerForSingleValueEvent(valueEventListener);