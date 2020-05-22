public class RjuIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        Connection connection = session.connection();
        try {
            Statement statement=connection.createStatement();
            if (object.getClass().getName()==Rju.class.getName()) {
                ResultSet rs=statement.executeQuery("select max(id) as Id from Rju");

                if(rs.next())
                {
                    int id=rs.getInt(1)+1;
                    Integer generatedId = new Integer(id);
                    return generatedId;
                }
            } else {
                ResultSet rs=statement.executeQuery("select max(id) as Id from AbstractCompany");

                if(rs.next())
                {
                    int id=rs.getInt(1)+100000;
                    Integer generatedId = new Integer(id);
                    return generatedId;
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}