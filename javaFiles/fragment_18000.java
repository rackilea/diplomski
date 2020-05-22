@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserAccount implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Venda> vendas = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<Venda> getVendas() { return vendas; }
    public void        setVendas(List<Venda> vendas) { this.vendas = vendas; }
    public void        addVenda(Venda v) { 
        this.vendas.add(v);
        v.setCliente(this);
    }

    /**
     * a Jackson module that is also a Jackson mixin 
     * it adds @JsonIgnore annotation to getVendas() method of UserAccount class
     */
    public static class FilterVendas extends SimpleModule {
        @Override
        public void setupModule(SetupContext context) {
            context.setMixInAnnotations(UserAccount.class, FilterVendas.class);
        }
        // implementation of method is irrelevant. 
        // all we want is the annotation and method's signature 
        @JsonIgnore
        public List<Venda> getVendas() { return null; }  
    }