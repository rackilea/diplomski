@Name("registrationBackingBean")
public class RegistrationBackingBean {

    @In(required=false)
    private Person person;

    @In(required=false)
    private Address address;

    public void wire() {
        person.setAddress(address);
    }

}