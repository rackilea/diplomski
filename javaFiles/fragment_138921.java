Product product = new Product();
 product.setName("The Product I am searching for");

 if(productInfo.contains(product)){
     int index = productInfo.indexOf(product);
     Product productFromList = productInfo.get(index);
 }