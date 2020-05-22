for(int i = 0; i<jsonArray.length(); i++){
    Product product = new Product();
    product.setId(jsonArray.getJSONObject(i).getInt("mId"));
    product.setName(jsonArray.getJSONObject(i).getString("mName"));
    product.setPrice(jsonArray.getJSONObject(i).getDouble("mPrice"));
    mProducts.add(product);

    System.out.println(mProducts.get(i));
}

for(Product product: mProducts){
    System.out.println(product); // now you have all values
}