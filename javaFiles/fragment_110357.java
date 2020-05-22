public class ExecuteScriptsAgainstOracle {

    public static void main(String args[]) throws Exception, SQLException {

        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:oracle:thin:@xxx:1521:yyy", "zzz", "zzz");
        flyway.setTable("auto_schema_setup_flyway");

        Database<?> database = DatabaseFactory.createDatabase(flyway.getConfiguration(), false);

// clean the database (remove all objects of the schema)
        flyway.clean();
        flyway.setSkipDefaultResolvers(true);
        flyway.setResolvers(new MyMigrationResolver(database, flyway.getConfiguration()));
        flyway.migrate();
    }

}