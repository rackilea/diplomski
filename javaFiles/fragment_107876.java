static class TeamSummary {

    ...

    public TeamSummary include(final Person person) {
        final TeamSummary result = new TeamSummary();
        result.fullnames = new ArrayList<>(fullnames);
        result.fullnames.add(person.firstname + " " + person.lastname);
        result.oldest = Comparator.<Person, Integer> comparing(p -> p.age).reversed()
                .compare(oldest, person) < 0
                        ? oldest
                        : person;
        return result;
    }
}

public static void main(final String[] args) {
    ...

    final TeamSummary reduced = personStream.reduce(
            TeamSummary.identity(),
            TeamSummary::include,
            TeamSummary::merge);
}