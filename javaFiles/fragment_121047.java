@Entity
public class A {

    private Long id;

    @ManyToOne
    @JoinTable(
       name = "A_B", 
       joinColumns = @JoinColumn(name = "B_ID"), 
       inverseJoinColumns = @JoinColumn(name = "A_ID")
    )
    private B b;

}