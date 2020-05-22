@Entity
public class City {
   @id
   Long id;
   String name;

   @JsonProperty("label")
   public String getName() { return name; }

   public void setName(String name){ this.name = name; }

   @JsonProperty("value")
   public Long getId() { return id; }

   public void setId(Long id){ this.id = id; }
}