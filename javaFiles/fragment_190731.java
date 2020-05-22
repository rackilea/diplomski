@Entity
@Table(name = "propertyList", uniqueConstraints = { @UniqueConstraint(columnNames = "HotelID") })
@SecondaryTable(name = "propertyDescriptionList", pkJoinColumns = @PrimaryKeyJoinColumn(name = "HotelID"), uniqueConstraints = { @UniqueConstraint(columnNames = "HotelID") })
public class Hotel implements Serializable {

    @Id
    @Column(name = "HotelID")
    private Long hotelId;

    @Column(name = "PropertyDescription", table = "propertyDescriptionList")
    private String propertyDescription;

}