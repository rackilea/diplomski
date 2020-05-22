ListView listView = (ListView) findViewById(R.id.list_view);
ArrayAdapter arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, randomProductList);
listView.setAdapter(arrayAdapter);
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference productsRef = rootRef.child("products"); //Added call to .child("products")
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> productList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.child("name").getValue(String.class);
            productList.add(name);
        }

        int productListSize = productList.size();
        List<String> randomProductList = new ArrayList<>();

        randomProductList.add(new Random().nextInt(productListSize)); //Add the random product to list
        arrayAdapter.notifyDatasetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG, "Error: ", task.getException()); //Don't ignore errors!
    }
};
productsRef.addListenerForSingleValueEvent(valueEventListener);