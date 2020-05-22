@Entity
@AccessType(value = "field")
@Table(name = "addresses")
public class Address
{
   @Id
   @OneToOne
   @JoinColumn(name = "person_id")
   private Person person;
   // ...
}