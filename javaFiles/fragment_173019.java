public class MainClass {

   public static void main(String[] args) {
       Set<Stud> al=new HashSet<>(); // use a set
       Scanner in=new Scanner(System.in); // init scanner here!
       System.out.println("Enter the details:");
       for(int i=1;i<=10;i++) {
           int rollNumber;
           String firstName;
           String lastName;
           int age;
           String gender;

           rollNumber=in.nextInt();
           firstName=in.next();
           lastName=in.next();
           age=in.nextInt();
           gender=in.next();

           Stud s=new Stud(rollNumber, firstName, lastName, age, gender);

           al.add(s);

           for (Stud stud : al) {
               System.out.println(stud.getRollnumber());
           }
       }
   }

private static class Stud {
    private final int rollNumber, age;
    private final String firstName, lastName;
    private final String gender;

    // assign the values you get in constructor
    public Stud(int rollNumber, String firstName, String lastName, int age, String gender) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public int getRollnumber() {
        return this.rollNumber;
    }
    public String getFirstname() {
        return this.firstName;
    }
    public String getLastname() {
        return this.lastName;
    }
    public int getAge() {
        return this.rollNumber;
    }
    public String getGender() {
        return this.gender;
    }

    // needed for Set
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.age;
        result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
        result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
        result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
        result = prime * result + this.rollNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Stud other = (Stud) obj;
        if (this.age != other.age)
            return false;
        if (this.firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!this.firstName.equals(other.firstName))
            return false;
        if (this.gender == null) {
            if (other.gender != null)
                return false;
        } else if (!this.gender.equals(other.gender))
            return false;
        if (this.lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!this.lastName.equals(other.lastName))
            return false;
        if (this.rollNumber != other.rollNumber)
            return false;
        return true;
        }
    }
}