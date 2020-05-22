@Entity
public class Person extends Model {
    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private Integer nameLength;

    public Long getId() {
        return id;
    }

    // getter for first name and last name with @Column annotation

    @Column(name = "complex_calculation")
    public Integer getNameLength() {
        return firstName.length() + lastName.length();
    }

    public Person (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        updateComplexCalculation();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        updateComplexCalculation();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        updateComplexCalculation();
    }

    private void updateComplexCalculation() {
        this.nameLength = firstName.length() + lastName.length();
    }
}