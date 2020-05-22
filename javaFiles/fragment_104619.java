mProductKeys = new ArrayList<String>();

mDatabaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot postSnapShot : dataSnapshot.getChildren())
        {
            Product product = postSnapShot.getValue(Product.class);
            mProducts.add(product);
            mProductKeys.add(postSnapShot.getKey());
        }
        mAdapter = new ProductsAdapter(ProductsActivity.this, mProducts);
        mRecyclerView.setAdapter(mAdapter);
        mProgressBar.setVisibility(View.INVISIBLE);
    }