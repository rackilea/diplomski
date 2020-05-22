import java.util.LinkedList;

class Bank {
    private LinkedList<Person> persons = new LinkedList<Person>();

    public void startup() {
        persons.add(new Person("Fred", "Cool"));
    }

    public LinkedList<Person> getPersonList() {
        return persons;
    }
}

class Person {
    String name, lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}

class Test {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.startup();

        String lastNameOfFirstPerson = bank.getPersonList().get(0).lastName;
        System.out.println(lastNameOfFirstPerson); // prints "Cool"
    }
}