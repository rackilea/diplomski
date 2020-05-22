public class Person {
    private String name;
    private int age;
    private String genre;

    public Person(String name, int age, String genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    // getters and setters
}

public class GroupBy {

    public static void main(String[] args) {

        List<Person> list = ArrayList();

        liist.add(new Person("Adam", 30, male));
        list.add(new Person("John", 32, male));
        list.add(new Person("Monica", 30, female));
        list.add(new Person("Sophia", 20, female));
        list.add(new Person("Carol", 25, female));

        Map<String, List<Person>> map = list.stream()
            .collect(Collectors.groupingBy(Person::getGender));
    }
}