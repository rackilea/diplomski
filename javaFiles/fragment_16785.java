public class DbcProvider {

    public Connection newDbc() {
        DataSourceUtils.getConnection(dataSource);
    }

}