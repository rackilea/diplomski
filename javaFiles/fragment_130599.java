@Entity
@Table(name = "component_supplement")
public class ComponentSupplement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne(cascase = Cascadetype.ALL)
    @JoinColumn(name = "component_id")
    private Component component;

    @ManyToOne(cascase = Cascadetype.ALL)
    @JoinColumn(name = "supplement_id")
    private Supplement supplement;

    private int quantity;
}