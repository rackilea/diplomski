public Application extends Controller {

    ... 

    public static Result getDataSource() throws NamingException {
        DataSource dataSource = (DataSource) play.api.libs.JNDI.initialContext().lookup("DefaultDS");

        return ok(dataSource.toString());
    }
}