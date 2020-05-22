public class Person {

    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name; // no need to clone; String is immutable
        this.birthDate = new Date(birthDate.getTime()); // need to clone, since Date is mutable.
    }
}