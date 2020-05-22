@Override
public User serachUserById(int userId) 
{
    User user = null;
    Connection connection = null;
    try {
        String storedProcedureInfoUsuario  =  "{ call searchUserById(?, ?, ?, ?, ?) }";

        connection  =  jdbcTemplate.getDataSource().getConnection();
        CallableStatement callableStatement = connection.prepareCall(storedProcedureInfoUsuario);

        callableStatement.setInt(1, userId);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.registerOutParameter(4, Types.VARCHAR);
        callableStatement.registerOutParameter(5, Types.VARCHAR);

        callableStatement.executeQuery();

        //
        user = new User();
        user.setName(callableStatement.getString(2));
        user.setLastName(callableStatement.getString(3));
        user.setEmail(callableStatement.getString(4));
        user.setState(callableStatement.getString(5));
    } 
    catch (SQLException ex) 
    {

Logger.getLogger(UsuarioDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        ex.printStackTrace();
    }
    finally 
    {
        if(connection != null)
        try 
        {
            connection.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    return user;
}