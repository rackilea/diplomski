for (DocumentSnapshot document : docs) {

    final Shops shops = new Shops();
    shops.setshopName(document.get("Name").toString());
    shops.setShopStatus(document.get("Status").toString());
    shops.setShopId(document.getId());

    String shop_id = document.getId();
    storageRef = storage.getReference().child("/shops_logo/" + shop_id +".png"); // get reference of shop_id named logo
    storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
        @Override
        public void onSuccess(Uri uri) {
            // puttindg logo from Firebase Storage to Image View
           shops.setUri(uri);// adding to list
           shopList.add(shops);
           // change event listener for in databaess
           shopsListAdapter.notifyDataSetChanged();
        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
           shopList.add(shops);
           // change event listener for in databaess
           shopsListAdapter.notifyDataSetChanged();
        }
    });
}