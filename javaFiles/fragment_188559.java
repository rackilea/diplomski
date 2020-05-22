@Entity
public class Employee {
    @EmbeddedId
    private EmployeeId id;
    private String name;

    public Employee(final String country, final int id) {
        this.id = new EmployeeId(country, id);
    }

    public String getCountry() {
        return id.getCountry();
    }
}   

@Embeddable
public class EmployeeId {
   private String country;
   @Column(name = "EMP_ID")
   private int id;

   //constructor + getters + equals +hashCode
}