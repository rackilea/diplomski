@Entity
public class Foo {

    @EmbeddedId
    private FooPK key;

    @MapsId("barId") //references EmbeddedId's property
    @JoinColumn(name = "bar_id", referencedColumnName = "id")
    @ManyToOne
    private Bar bar;
}

@Embeddable
public class FooPK {

    @Column(name = "id")
    private int id;
    @Column(name = "bar_id")
    private int barId;
}