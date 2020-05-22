myCurrentProduct = new Product();  //create a default constructor in Product model class
myCurrentProduct.setTitle(tempProduct.getTitle());
myCurrentProduct.setQuantity("5");
myCurrentProduct.setPrice("50000");
myCurrentProduct.setDiscount(tempProduct.getDiscount());
binding.setPopUpProduct(myCurrentProduct);