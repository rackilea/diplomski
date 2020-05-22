public class Person {
    public PersonBuilder copy() {
        return new PersonBuilder()
                       .withName(this.name)
                       .withAge(this.age)
                       .withPhone(this.phone);
    }

    public Person changeName(String name) {
        return copy().withName(name).build();
    }

    public Person changeAge(int age) {
        return copy().withAge(age).buid();
    }
}