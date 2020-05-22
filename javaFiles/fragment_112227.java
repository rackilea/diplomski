public class BusinessContact extends Contact {

    private final String organization;

    public BusinessContact(String name, String org) {
        super(name);
        this.organization = org;
    }

    @Override
    public String displayContact() {
        return super.displayContact() + "Organization: " + organization + ".";
    }
}