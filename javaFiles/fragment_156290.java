@Entity
public class TestEntity {

    @OneToMany
    // add these annotations for a work-around
    @JoinTable(name="TESTENTITY_SUBENTITY")
    @MapKeyColumn(name = "MAP_KEY", table="TESTENTITY_SUBENTITY")
    public Map<String, SubEntity> map = new HashMap<String, SubEntity>();

    @Id
    @GeneratedValue(strategy = AUTO)
    protected long id;

    public String name;

    public TestEntity() {
}

    public TestEntity(String name) {
        this.name = name;
    }
}