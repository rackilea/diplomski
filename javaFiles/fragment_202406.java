@Entity
@Table(name = "ApiTable", schema = "TestApi")
public class User {

    @Id   
    private String phone;

    private String message;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setLastName(String message) {
        this.message = message;
    }
}