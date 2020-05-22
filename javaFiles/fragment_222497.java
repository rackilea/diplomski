public class A {

    @Column(insertable = false, updateable = false)
    private Integer bId;

    @ManyToOne
    private B b;

}