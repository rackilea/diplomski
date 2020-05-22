public class A {

    private Integer bId;

    @JoinColumn(name="b_id", insertable = false, updatable = false)
    @ManyToOne
    private B b;

}