public List<Item> shoppingCart = new ArrayList<Item>();
try { 
   temp= new Electronics(name,price,quantity,weight, fragile, state);
   ...
   shoppingCart.add(temp);
} catch (IllegalArgumentException e) { 
  //handle exception
}