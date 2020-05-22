@Embeddable
public class FooErrorId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer fooId; // type corresponds to FooEntity's id

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ErrorType type;

    ...
}