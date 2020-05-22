@Entity
@Table(name = "Zips")
public class Zip implements Serializable
{
    @EmbeddedId
    private ZipId embeddedId;

    @ManyToOne
    @JoinColumn(name = "country_code", referencedColumnName = "iso_code")
    private Country country = null;

    ...
}

@Embeddable
public class ZipId implements Serializable
{
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "code")
    private String code;

    ...
}