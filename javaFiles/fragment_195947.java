public class CustomSPParamSetter implements PreparedStatementSetter{

@Override
public void setValues(PreparedStatement ps) throws SQLException {

    CallableStatement eventCallableSt=(CallableStatement)ps;
    eventCallableSt.registerOutParameter(1, java.sql.Types.SMALLINT);
    eventCallableSt.registerOutParameter(2, java.sql.Types.VARCHAR);
    eventCallableSt.registerOutParameter(3, java.sql.Types.INTEGER);
    eventCallableSt.registerOutParameter(4, java.sql.Types.CHAR);
}
}