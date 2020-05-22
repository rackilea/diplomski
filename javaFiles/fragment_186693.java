@Entity
public class Product implements Serializable{
   private int id;
   private String name;
   private String photo;
   private double price;
   private int quantity;
   private Double rating;
   private Provider provider;
   private String description;

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   private List<Category> categories = new ArrayList<>();

   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   private List<Photo> photos = new ArrayList<>();

   // Getters & Setters
}