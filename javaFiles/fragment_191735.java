enum People {
    Joe1("Joe", "31", "Engineer"), 
    Joe2("Joe", "35", "Manager"), 
    Sam1("Sam", "22", "Student"),
    Sam2("Sam", "30", "lawyer"), 
    Sam3("Sam", "45", "judge");

    private String personName;
    private String age;
    private String occupations;

    private static Map<String, List<People>> byName;

    static {
        byName = Arrays.stream(values())
                .collect(Collectors.groupingBy(People::getPersonName, 
                          Collectors.toList()));
    }

    People(String personName, String age, String occupations) {
        this.personName = personName;
        this.age = age;
        this.occupations = occupations;
    }
    public static List<People> getByName(String personName) {
             return byName.get(personName);
    }
}