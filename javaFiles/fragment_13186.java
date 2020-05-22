for (DataSnapshot postSnapshot : snapshot.getChildren()) {
    ProductEntity upload = postSnapshot.getValue(ProductEntity.class);
    Log.d("error", "onDataChange: " + upload.about);

    List<ProductImage> images = new ArrayList<>() ;
    for(DataSnapshot datas : postSnapshot.child("images").getChildren()){

    ProductImage upload_image = datas.getValue(ProductImage.class);
    images.add(upload_image) ;
    }
    upload.image = images ;
    productList.add(upload);
}