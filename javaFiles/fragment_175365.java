@Stateless
@Path("book")
public class BookResource {

    @EJB
    private BookEJB bookEJB;

    //...
}