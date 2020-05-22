// First of all, these data are of a patient, not of a hospital, so I renamed the class...
public class Patient
{
    private String name,address;
    private int age, phoneNumber, securityNumber;
    private char sex;

    // No need a no-argument-constructor
    public Patient(String name, char sex, String address, int age, int
            phoneNumber, int securityNumber)
    {
        // Just to remember: Java generates a super() call even if you do not write it out
        super();
        this.name = name;
        this.address = address;
        this.age = age;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.securityNumber = securityNumber;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
}

// Now comes the part that is about more patients. Could be named a hospital...
public class Hospital
{
    // A list of patents
    private final List<Patient> patients =  new ArrayList<>();

    // Prints out the names of the patents on the list
    public void showListOfNames()
    {
        for(final Patient : this.patients)
        {
            System.out.println(patient.getName());
        }
    }

    // The main method. It does not have to be in a separated class...
    public static void main(String[] args)
    {
        final Scanner x = new Scanner(System.in); // Still not in use...
        final Hospital h = new Hospital(); // our hospital instance, with the list of patients

        // Adding patents to the hospital's list
        h.patients.add(new Patient("dan",'f',"nuyoo",12,2356445,001));
        h.patient.add(new Patient("fredy",'m',"idk",34,34657,002));
        h.patient.add(new Patient("dan",'m',"west",21,345546,003));

        // Printing out the names
        showListOfNames();
    }

}