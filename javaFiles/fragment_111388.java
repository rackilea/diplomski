for(int i = 0; i<jsonArray.length(); i++){
    mProduct.setId(jsonArray.getJSONObject(i).getInt("mId"));
    mProduct.setName(jsonArray.getJSONObject(i).getString("mName"));
    mProduct.setPrice(jsonArray.getJSONObject(i).getDouble("mPrice"));
    mProducts.add(mProduct);

    System.out.println(mProducts.get(i)); // shows you what you want, because you are in the loop
}

for(Product product: mProducts){
    System.out.println(product); // shows, what is realy in the ArrayList. it is always last value
}