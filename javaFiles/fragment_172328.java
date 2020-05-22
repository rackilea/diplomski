import java.util.ArrayList;

   public class ShoppingCart {

     ArrayList<Visitable> items = new ArrayList<>(); // <---- this will solve the problem

     public double calculatePostage(){
        //Create a visitor

        PostageVisitor visitor = new PostageVisitor();

     // iterate through all items
          for( Visitable item: items){

             item.accept(visitor);
         }

        double postage = visitor.getTotalPostage();

        return postage;

     }
 }