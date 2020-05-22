final String test = text.toString().toLowerCase() ;
    productsRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                ProductEntity entity = postSnapshot.getValue(ProductEntity.class);
                if(entity.about.toLowerCase().contains(test) || entity.vendor_address.toLowerCase().contains(test)) {
                    searchList.add(entity) ;
                }
            }