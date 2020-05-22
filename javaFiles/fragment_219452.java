public class Patient {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private PhoneNumber phneNum;
    private String email;

    public Patient(String firstName, String middleName, String lastName, PhoneNumber phneNum, String email) {
         this(0, firstName, middleName, lastName, phneNum, email);
    }

    public Patient(int id, String firstName, String middleName, String lastName, PhoneNumber phneNum, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phneNum = phneNum;
        this.email = email;
   }
//....