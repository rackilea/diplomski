@Embeddable
public class Address {
    String street;
    String town;

    @Embedded
    @Access(AccessType.PROPERTY)
    ZipCode zipCode;

    public String getZipCode() {
        return zipCode().getZip();
    }

    public void setZipCode(String zip) {
        zipCode.setZip(zip);
    }
}