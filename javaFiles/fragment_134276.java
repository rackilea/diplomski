public void addToList(String productName,double prize,int quantity){
         Cart cart = new Cart();//assuming default constructor exists
        cart.setProductName(productName);
        cart.setPrize(prize);
        cart.setQuantity(quantity);
        list.add(cart);
    }