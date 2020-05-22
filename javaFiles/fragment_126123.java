@Entity
public class MainRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade=CascadeType.ALL, targetEntity=Ref1.class)    
    Ref ref1;

    @ManyToOne(cascade=CascadeType.ALL, targetEntity=Ref2.class)
    Ref ref2;
}