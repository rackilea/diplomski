@Table(name = "hr_employee")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class HrEmployee {

    @Column(name="first_name")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setName(String name){
        this.firstName = name;
    }
    public String getName(){
        return this.firstName;
    }
}