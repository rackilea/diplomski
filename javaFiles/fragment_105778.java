@ManagedBean(name="entityController")  
@SessionScoped
public class EntityController {

   @ManagedProperty("#{client}")
   private Client client;