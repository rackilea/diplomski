public class PersonMain {
    public static void main(String[] args) {
        List<Person> personsList = new ArrayList<>();

        personsList.add(new Person("John", "Doe", 25, 180, 80));
        personsList.add(new Person("Jane", "Doe", 30, 169, 60));
        personsList.add(new Person("John", "Smith", 35, 174, 70));
        personsList.add(new Person("John", "T", 45, 179, 99));

        Object[] objects = personsList.stream().collect(Collector.of(
                () -> new PersonStatistics(p -> p.getFirstName().equals("John")),
                PersonStatistics::accept,
                PersonStatistics::combine,
                PersonStatistics::toStatArray));
        System.out.println(Arrays.toString(objects));
    }
}