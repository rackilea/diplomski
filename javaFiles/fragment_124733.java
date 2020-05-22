public class Product {

     private int id;

     public Product(int id) {
        this.id = id;
     }

     //add getters and settes for id

     public boolean equals(Object obj) {
         Product product = (Product)obj;
         if(id == product.getId()) {
             return true;
         }
         return false;
     }

     public int hashcode() {
         return 1;
     }
}