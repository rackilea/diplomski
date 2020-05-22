@Entity
@Table(name = "store")
public class LCBOStore {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "addressLineOne", length = 255)
    private String addressLineOne;

    @Column(name = "addressLineTwo", length = 255)
    private String addressLineTwo;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "postalCode", length = 10)
    private String postalCode;

    @Column(name = "latitude", length = 255)
    private String latitude;

    @Column(name = "longitude", length = 255)
    private String longitude;

    @Column(name = "updatedAt", length = 255)
    private String updatedAt; //Convert to Date

//getters and setters

}