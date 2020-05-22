@Entity
@IdClass(FooId.class)
class Bar {
    @Id
    private String fooId;
    /* ... */
}