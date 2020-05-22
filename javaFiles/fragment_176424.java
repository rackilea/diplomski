public class MyService {
    @Autowired 
    private BeanFactory factory;

    public void myMethod(String jndiName) {
        DataSource myDataSource = factory.getBean(jndiName, DataSource.class);
    }
}