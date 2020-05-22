class Main
{
    public static void main(String[] args)
    {
        Database db = new Database();
        if (db.connect(/* parameters for database connection here */)) {
            final Connection conn = db.getConnection();
            // you can use conn for your queries. If they are in other classes, pass connection as parameter.
        }
    }
}