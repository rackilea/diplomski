Class PersonDetail
{
    protected String firstName;
    protected String  lastName;
    protected String  jobTitle;
    protected String  dateOfBirth;
    protected String  bloodGroup;
    /* Getter Setter */ of the above attributes
}
class PersonContact extends PersonDetail
{
    private ArrayList<String> listOfEmail;
    private ArrayList<String> listOfURL;
    private ArrayList<String> listOfFaxNo;
    private ArrayList<String> listOfOfficeNo;
    private List<Address> listOfAddress;
    /* Getter Setter */ of the above attributes
}
class Address 
{
    private String streetName;
    private String city;
    private String zipcode;
    private String state;
    /* Getter Setter */ of the above attributes
}