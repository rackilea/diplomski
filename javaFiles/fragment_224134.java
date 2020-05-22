public class Client{

    private String ClientName;
    private Address address;
    private List<String> PhoneNumbers;

    public Client() {
        this.PhoneNumbers = new ArrayList<String>();
    }

    public Client(String clientName, String address, String city, String country, String homePhone, String officePhone, String cellPhone) {
        this();
        ClientName = clientName;
        address = new Address(...); // No idea of the parameters for this...
        AddPhoneNumber(homePhone);
        AddPhoneNumber(officePhone);
        AddPhoneNumber(cellPhone);
    }