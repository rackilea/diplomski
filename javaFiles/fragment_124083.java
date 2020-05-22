public class DAO {
    private final DataSource ds;

    public void foo(...) {
        Connection connection = ds.getConnection();
        try {
            // do work there
        } finally {
            connection.close();
        }
    }
}


public class MainPanel extends JPanel {
    private final DAO dao;

    public MainPanel(DAO dao) {
        this.dao = dao;
    }

    // ...
}


public class Main {
    public static void main(String[] args) {
        Class.forName("org.hsqldb.jdbcDriver");
        BoneCPDataSource ds = new BoneCPDataSource();
        ds.setJdbcUrl("jdbc:hsqldb:mem:test");
        ds.setUsername("sa");
        ds.setPassword("");

        DAO dao = new DAO(ds);
        MainPanel mainPanel = new MainPanel(dao);
        // ...
    }
}