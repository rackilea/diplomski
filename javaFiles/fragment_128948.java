import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    static class Person{
        int age;
        String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();

        persons.add(new Person(20,"John"));
        persons.add(new Person(25,"Alice"));
        persons.add(new Person(30,"Peter"));
        persons.add(new Person(25,"Stefan"));


        List<Person> results = persons.stream()
                .filter(p -> p.age <= 25 && p.name.equals("Stefan"))
                .collect(Collectors.toList());

        for(Person p : results)
            System.out.println(p.name);

    }
}