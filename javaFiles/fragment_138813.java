import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(25);
        people.add(new Person("Isabella", 'F'));
        people.add(new Person("Jacob", 'M'));
        people.add(new Person("Sophia", 'F'));
        people.add(new Person("Ethan", 'M'));
        people.add(new Person("Emma", 'F'));
        people.add(new Person("Michael", 'M'));
        people.add(new Person("Addison", 'F'));
        people.add(new Person("William", 'M'));
        people.add(new Person("Elizabeth", 'F'));
        people.add(new Person("Alexander", 'M'));
        people.add(new Person("Ella", 'F'));
        people.add(new Person("Joshua", 'M'));
        people.add(new Person("Olivia", 'F'));
        people.add(new Person("Mason", 'M'));
        people.add(new Person("Ava", 'F'));
        people.add(new Person("Evan", 'M'));
        people.add(new Person("Emily", 'F'));
        people.add(new Person("Nicholas", 'M'));
        people.add(new Person("Abigail", 'F'));
        people.add(new Person("Gavin", 'M'));

        String maleName = null;
        String femaleName = null;
        for (Person p : people) {

            if ('M' == p.getSex()) {

                maleName = p.getName();

            }
            if ('F' == p.getSex()) {

                femaleName = p.getName();

            }

            if (maleName != null && femaleName != null) {

                System.out.printf("%13.10s%10.10s%n", femaleName, maleName);
                maleName = null;
                femaleName = null;

            }
        }
    }

    public static class Person {

        private String name;
        private char sex;

        public Person(String name, char sex) {
            this.name = name;
            this.sex = sex;
        }

        public char getSex() {
            return sex;
        }

        public String getName() {
            return name;
        }

    }

}