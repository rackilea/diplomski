public class Person {
    String name;

    public Person(String personName) {
        name = personName;
    }

    public String greet(String yourName) {
        return String.format("Hi %s, my name is %s", yourName, name);
    }

    public static void main(String [] args)
    {
        Person p = new Person("Marcx");  // create an object Person
        System.out.println(p.greet("Ankit hacker")); //print the greet message
    }
}