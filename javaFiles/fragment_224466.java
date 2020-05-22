public class Product implements Comparable<Product>{
   private String productId;
   private List categoryList;

  //...setter and getter for category List

   public int compareTo(Product p) {
       //return -1, 0 or 1 based on what you decide makes p to be less than this
   }

}

//sort it
java.util.Collections.sort(myProductList);