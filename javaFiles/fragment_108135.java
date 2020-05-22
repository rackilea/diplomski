@Entity
public class Person {

    public static Person create() {
        Person person = new Person();
        person.setAddress(new Address());
        return person;
    }

    // ...
}