public class Connection{

    private static Connection instance = null;
    private String connectionString;

    protected Connection() {
    }

    public static Connection getInstance() {
       if(instance == null) {
          instance = new Connection();
       }
       return instance;
    }

    public void setConnectionString(String connectionString){
        this.connectionString = connectionString;
    }

    public String getConnectionString(){
        return this.connectionString;
    }
}