@Entity
public class Car 
{
    @NamedQueries(
    {
        @NamedQuery(name = "Car.findByBrandAndColor", query = "SELECT c FROM Car WHERE c.brand = :brand AND color = :color")
    })
}