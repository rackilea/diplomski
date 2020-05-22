public class PersonalContact extends Contact {

    private final String dateofBirth;

    public PersonalContact(String name, String dateOfBirth) {
        super(name);
        this.dateofBirth = dateOfBirth;
    }

    @Override
    public String displayContact() {
        return super.displayContact() + "Date of birth: " + dateofBirth + ".";
    }
}