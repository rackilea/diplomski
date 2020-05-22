@MappedSuperclass
public class BaseCustomers {
    @Column(name="OldId") private String oldId;
    @Column(name="Name") private String name;
    @Column(name="Address") private String address;
}