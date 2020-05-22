public class EmployeeInfo {
    int id;
    static String name;
    Date DoB, DoJ;

    public void setName(final String name) {
        this.name = name;
    }

    public void setDateOfBirth(final Date DoB) {
        this.DoB = DoB;
    }

    public void setDateOfJoining(final Date DoJ) {
        this.DoJ = DoJ;
    }

    void print() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Date Of Birth: " + DoB);
        System.out.println("Date of Joining: " + DoJ);
    }
}