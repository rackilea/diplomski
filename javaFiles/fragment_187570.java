@XmlRootElement
@XmlType(propOrder={"idGear", "name", "year", "price"})
@Entity(name="gear")
public class Gear{

    @Id
    @GeneratedValue
    int idGear;
    private String name;
    private int year;
    private double price;

}