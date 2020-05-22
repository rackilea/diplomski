@Entity
public class A {
    @Id
    private String id;

    @Enumerated
    private Key firstB; 

    @Enumerated
    private Key secondB;
}