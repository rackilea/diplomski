@Entity
public class flightEntity implements Serializable {
   // ....

   @ManyToOne
   @JoinColumn(name="<name_of_foreignkey_column>")
   private itineraryTraveller traveller;

   // ...
}