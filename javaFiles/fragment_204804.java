public class CustomGenerator implements IdentifierGenerator {

    @Override
    public synchronized Serializable generate(SessionImplementor session, Object obj) {
        if (obj instanceof SupportTicket) {
            String sequenceName = ((SupportTicket) obj).getProjectId();
            Serializable result = null;
            try {
                Connection c = session.connection();
                Statement s = c.createStatement();
                s.execute("CREATE TABLE IF NOT EXISTS sequences\n" +
                        "     (\n" +
                        "         name VARCHAR(70) NOT NULL UNIQUE,\n" +
                        "         next INT NOT NULL\n" +
                        "     );");
                s.execute("INSERT INTO sequences (name, next)\n" +
                        "VALUES ('" + sequenceName + "', @current := 1)\n" +
                        "ON DUPLICATE KEY UPDATE \n" +
                        "next = @current := next + 1");
                ResultSet resultSet = s.executeQuery("SELECT @current");
                if (resultSet.next()) {
                    int nextValue = resultSet.getInt(1);
                    result = sequenceName + "-" + nextValue;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        } else {
            return null;
        }
    }
}