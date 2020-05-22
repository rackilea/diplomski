@Named 
@SessionScoped 
public class EmpresaMB implements Serializable {

   @EJB
   private EmpresaEJBRemote empresaEJB;
   private Empresa empresa;

   @Named 
   @Produces
   private PessoaMB pessoaMB;
}