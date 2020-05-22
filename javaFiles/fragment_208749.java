public class Person {
    // In real code you should almost *never* have public variables
    // like this. It would normally be private, and you'd expose
    // a public getName() method. It might be final, too, with the value
    // assigned in the constructor.
    public String name;

    public static void main(String[] args) {
        Person x = new Person();
        x.name = "Fred";
        PersonPresenter.displayPerson(x);
    }
}

class PersonPresenter {

    // In a real system this would probably be an instance method
    public static void displayPerson(Person person) {
        System.out.println("I present to you: " + person.name);
    }
}