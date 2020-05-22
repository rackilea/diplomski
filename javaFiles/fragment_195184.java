@Stateless
public class FooBean implements Foo {
    @PersistenceContext(unitName="MyPu1")
    EntityManager em1;

    // ...
}