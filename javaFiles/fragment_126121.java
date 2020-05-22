@Entity
public class Ref1 extends Ref {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}