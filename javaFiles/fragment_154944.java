currentPerson.setPerson(newPerson);


public class Person{

    private StringProperty name = new SimpleStringProperty();

    // ....


    public void setPerson(Person person) {
        // ....
        this.name.set(person.name.get());
    }
}