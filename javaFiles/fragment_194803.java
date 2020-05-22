public class Main {
    public static void main(String[] args) {
        final List<Person> persons = new LinkedList<>();
        persons.add(new Person("Albert", "Einstein"));
        persons.add(new Person("James", "Bond"));

        // sort by lastname, ascending
        Collections.sort(persons, (p1, p2) -> p1.getLastName().toUpper().compareTo(p2.getLastName().toUpper()));        
        persons.forEach(System.out::println);
    }
}