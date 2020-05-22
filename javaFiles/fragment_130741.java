public static void main(String[] args) {
    String input =
            "matt smith,1983-02-03,2020-03-02\n" +
                    "sarah jones,1966-12-02,2018-12-04\n" +
                    "john smith,1967-03-04,2017-04-04\n";
    Set<DeceasedPerson> deceasedPersonList = new TreeSet<>(Comparator.comparing(o -> o.deathDate));
    try (Scanner scanner = new Scanner(input)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] array = line.split(",");
            DeceasedPerson deceasedPerson = new DeceasedPerson(array[0],
                    LocalDate.parse(array[1]), LocalDate.parse(array[2]));
            deceasedPersonList.add(deceasedPerson);
        }
    }
    deceasedPersonList.forEach(System.out::println);
}