@Entity
public class Bar {

    @OneToOne
    @JoinColumn(name = "baz_id", nullable = false, fetch=FetchType.Lazy)
    private Baz baz;

    //...
}