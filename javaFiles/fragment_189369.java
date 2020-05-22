public class Person {
    @OneToMany(mappedBy = "person1")
    private List<RelationShip> relationships;

    public List<Person> getSiblings() {
        List<Person> result = new ArrayList<Person>();
        for (RelationShip r : relationShips) {
            if (r.getType() == RelationshipType.SIBLING) {
                result.add(r.getPerson2());
            }
        }
    }

    ...
}