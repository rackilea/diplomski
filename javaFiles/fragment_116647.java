@Entity
public class MyData {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   public MyData() {
      // ...
   }

   public MyData(String fieldList, MyData md) {
      // ...
   }

   // Getters and setters here...
}