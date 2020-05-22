@Entity
public class A {

    private Long id;

    @ManyToOne
    @JoinColumn(name="B_ID")
    private B b;

}