public class CustomSQLExceptionTranslator implements SQLExceptionTranslator{
    @Override
    protected DataAccessException translate(String task, String sql, SQLException ex) {

    switch(ex.getErrorCode()){
        case(Primary Key Violation Error Code): {
            return new PrimaryKeyViolationException(ex); //Or whatever exception you want.
        }
        ...
        default:{
            return ex;
        }
    }
}