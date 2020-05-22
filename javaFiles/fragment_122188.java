@Entity
class Bar {
    @EmbeddedId
    private FooId fooId;
    /* ... */
}