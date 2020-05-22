static class Person {
    public String firstname;
    public String lastname;
    public int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public static Person getNullObjectYoung() {
        return new Person("", "", 0);
    }
}

static class TeamSummary {
    public List<String> fullnames;
    public Person oldest;

    public static TeamSummary merge(TeamSummary lhs, TeamSummary rhs) {
        TeamSummary result = new TeamSummary();
        result.fullnames = new ArrayList<>();
        result.fullnames.addAll(lhs.fullnames);
        result.fullnames.addAll(rhs.fullnames);
        result.oldest = Comparator.<Person, Integer>comparing(p -> p.age).reversed()
                .compare(lhs.oldest, rhs.oldest) < 0
                ? lhs.oldest
                : rhs.oldest;
        return result;
    }

    public static TeamSummary of(Person person) {
        TeamSummary result = new TeamSummary();
        result.fullnames = new ArrayList<>();
        result.fullnames.add(person.firstname + " " + person.lastname);
        result.oldest = person;
        return result;
    }

    public static TeamSummary identity() {
        TeamSummary result = new TeamSummary();
        result.fullnames = new ArrayList<>();
        result.oldest = Person.getNullObjectYoung();
        return result;
    }
}

public static void main(String[] args) {        
    Stream<Person> personStream = Arrays.asList(
            new Person("Tom", "T", 32),
            new Person("Bob", "B", 40))
            .stream();

    TeamSummary result = personStream.collect(
            Collectors.reducing(
                    TeamSummary.identity(),
                    TeamSummary::of,
                    TeamSummary::merge
            ));
    System.out.println(result.fullnames + " " + result.oldest.age);

}