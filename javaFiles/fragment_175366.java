@Path("book")
@RequestScoped
public class BookResource {

    @Inject
    private BookEJB bookEJB;

    //...
}