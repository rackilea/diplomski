@Entity
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @OneToMany(mappedBy = "supplement")
    private Set<ComponentSupplement> suplements;
}