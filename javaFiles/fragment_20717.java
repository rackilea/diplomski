import java.util.*;

final class Person {
    private final String name;

    public Person(String name) {
        // TODO: Nullity prohibition
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != Person.class) {
            return false;
        }
        return name.equals(((Person)other).name);
    }
}

class Test {
    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Jon");
        Person p2 = new Person("Jon");
        System.out.println(p1.equals(p2)); // true

        Set<Person> people = new HashSet<Person>();
        people.add(p1);
        people.add(p2);
        System.out.println(people.size()); // 2!
    }
}