@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.mypackage.entities.AuditInfo.on*(..))")
    public void setAuditHistory(JoinPoint jp){      
        final AuditInfo info = ((AuditInfo)jp.getThis());
        JdbcTemplate jdbcTemplate = ApplicationContextProvider.getApplicationContext().getBean(JdbcTemplate.class);
        jdbcTemplate.execute(new CallableStatementCreator() {
            public CallableStatement createCallableStatement(Connection conn) throws SQLException {
                CallableStatement stmt = conn.prepareCall("begin ah_audit_pkg.SetAudit(?,?); end;");
                stmt.setString(1, info.getAuditUser());
                if(info.getAuditLocation() != null && info.getAuditLocation().trim().length() !=0) {
                    stmt.setString(2, info.getAuditLocation());
                } else {
                    stmt.setString(2, info.getAuditUser());
                }
                return stmt;
            }
        }, new CallableStatementCallback<Object>() {
            public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                return cs.executeUpdate();
            }
        });
    }  
}