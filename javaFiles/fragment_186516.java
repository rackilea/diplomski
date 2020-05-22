@Stateless
public class MyBean {

    @Resource(lookup = "java:/testDS")
    private DataSource dataSource;

    public void testDatasource() {
        try (Connection connection = dataSource.getConnection()) {

            // use the connection 

        } catch (SQLException e) {
            throw new SomeRuntimeException(e);
        }
    }
}