@ManagedBean
@RequestScoped
public class Database
{

    private static Statement statement;
    private static Connection connection;
    private ResultSet result;

    public static void main(String[] args)
    {
        // ...