public class Demo {

    private static class Person {
       public int age;
       public String name;

       public Person(int age, String name) {
           this.age = age;
           this.name = name;
       }
    }

    public static void main(String... args) {

        // Create and populate a list of people with individuals
        List<Person> people = new ArrayList<>();
        people.add(new Person(32, "Fred"));
        people.add(new Person(45, "Ginger"));
        people.add(new Person(66, "Elsa"));

        // Iterate over the list (one person at a time)
        for (Person person : people) {
            if (person.age > 60) {
                System.out.println("Old person: " + person.name);
            }
        }
    }
}