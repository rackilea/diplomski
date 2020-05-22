public class Item {

   //...

   @JsonIgnoreProperties("items") 
   @ManyToOne
   private Order order = new HashSet<>();

   //...
}