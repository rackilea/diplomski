public class MyService {
    @Autowired 
    private JndiDataSourceLookup lookup;

    public void myMethod(String jndiName) {
        DataSource myDataSource = lookup.getDataSourcejndiName);
    }
}