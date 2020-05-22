public class Address {

    @JsonDeserialize(converter = PhoneConverter.class)
    protected List<Phone> phones;

}