public class Venda implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UserAccount cliente;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public UserAccount getCliente() { return cliente; }
    public void        setCliente(UserAccount cliente) { this.cliente = cliente; }

    /**
     * a Jackson module that is also a Jackson mixin 
     * it adds @JsonIgnore annotation to getCliente() method of Venda class
     */
    public static class FilterCliente extends SimpleModule {
        @Override
        public void setupModule(SetupContext context) {
            context.setMixInAnnotations(Venda.class, FilterCliente.class);
        }
        // implementation of method is irrelevant. 
        // all we want is the annotation and method's signature 
        @JsonIgnore
        public UserAccount getCliente() { return null; }
    }
}