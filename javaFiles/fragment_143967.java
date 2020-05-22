@Entity
@Table(name = "fooerror")
public class FooErrorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private FooErrorId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foo_id", nullable = false)      
    @MapsId("fooId") // maps fooId attribute of the embedded id
    private FooEntity foo;

    @Column(name = "descripcion")
    private String description;

    ...
}