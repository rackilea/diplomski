@Entity
@Table(name="TableB")
public class ClassB {
    @MapsId
    @OneToOne
    @JoinColumn
    private ClassA classA

    private String paramB;

    // getters and setters here - including for ClassA