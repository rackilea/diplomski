public class Zip {

    @ManyToOne
    @JoinColumn(name = "country_code", referencedColumnName = "iso_code")
    private Country country = null

    @Column(name = "country_code")
    private String countryCode;

}