@Entity
public class EntityWithStaticNestedClass implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private EntityWithStaticNestedClass.StaticNestedClass nested;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public EntityWithStaticNestedClass.StaticNestedClass getNested() { 
        return nested;
    }

    public void setNested(EntityWithStaticNestedClass.StaticNestedClass nested) {
        this.nested = nested;
    }

    @Entity
    public static class StaticNestedClass implements Serializable {
        @Id
        @GeneratedValue
        private Long id;

        public Long getId() { return id; }

        public void setId(Long id) { this.id = id; }
    }
}