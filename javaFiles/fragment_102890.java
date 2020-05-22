public class Person {
    @OneToMany
    @JoinColumn(name = "slave_id"),
    private List<Relation> slaves;

    @OneToMany
    @JoinColumn(name = "master_id"),
    private List<Relation> masters;

    public List<Relation> getRelations() {
        List<Relation> result = new ArrayList<>(slaves);
        result.addAll(masters);
        return result;
    }
}