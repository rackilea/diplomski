@Entity
@Table(name="Cities")
public class City {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private List<Employee> employees;
}