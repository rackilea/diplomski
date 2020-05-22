Restrictions<Product> restrictions = new Restrictions<Product>(){
       public void query(Product queryObject){
         queryObject.setPrice(gt(10));
         queryObject.setPromo(order(false));
         //gt() and order() inherited from Restrictions
       }            
 }