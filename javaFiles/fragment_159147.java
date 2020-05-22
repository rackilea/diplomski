@Entity
@Table(name="Customers")
public class Customers extends BaseCustomers {
    @Column(name="NewId") private String newId;
    @Column(name="PhoneNumber") private String phoneNumber;
}