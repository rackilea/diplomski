@Data
@Entity
public class Car {
    private String id;
    private String number;
    private String registrationNumber;

    @javax.persistence.OrderBy("id ASC")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Driver> drivers;
}