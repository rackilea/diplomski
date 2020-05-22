@Entity
@AccessType(value = "field")
@Table(name = "addresses")
public class Address
{
   @Id
   private int personId;

   @MapsId
   @OneToOne
   @JoinColumn(name = "person_id")
   private Person person;
   // ...
}