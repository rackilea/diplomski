import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {
    public String name;
    public int age;

    @Override
    public int compareTo(Person person) {
        return new Integer(this.age).compareTo(person.age);
    }


    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Kevin";
        person.age = 28;
        Person person2 = new Person();
        person2.name="Bob";
        person2.age = 40;
        Person person3 = new Person();
        person3.name="Joe";
        person3.age = 90;

        List<Person> people = new ArrayList<Person>();
        people.add(person2);
        people.add(person3);
        people.add(person);

        Collections.sort((List<Person>)people);

        for(Person p:people){
            System.out.println(p.name);
        }
    }

}