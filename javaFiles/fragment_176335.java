@Document(collection = "authority")
public class Authority {

    @Id
    private String _id;

    // TODO remove this right now !!! :)
    @DBRef(lazy = true)
    private List<User> users;

    // bla bla bla
}