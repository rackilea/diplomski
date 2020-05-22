@Entity
@Getter
@Setter
public class FactoryWorker {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long iD;
    // Add this
    @ManyToOne
    private FactoryPublisher factoryPublisher;

    // ...
}