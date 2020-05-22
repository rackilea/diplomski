public class ManualSaleStoredProcedureDao {

private SimpleJdbcCall getAllSytemUsers;

public List<SystemUser> getAllSytemUsers(String clientCode) {

    MapSqlParameterSource in = new MapSqlParameterSource();
    in.addValue("pi_client_code", clientCode);
    Map<String, Object> result = getAllSytemUsers.execute(in);
    @SuppressWarnings("unchecked")
    List<SystemUser> systemUsers = (List<SystemUser>) result
            .get(VSCConstants.GET_SYSTEM_USER_OUT_PARAM1);
    return systemUsers;

}

public void setDataSource(DataSource dataSource) {

    getAllSytemUsers = new SimpleJdbcCall(dataSource)
            .withSchemaName(VSCConstants.SCHEMA)
            .withProcedureName(VSCConstants.GET_SYSTEM_USER_PROC_NAME)
            .declareParameters(
                    new SqlParameter(
                            "pi_client_code",
                            OracleTypes.NUMBER,
                            "pi_client_code"),
                    new SqlInOutParameter(
                            "po_system_users",
                            OracleTypes.ARRAY,
                            "T_SYSTEM_USER_TAB",
                            new OracleSystemUser()));

}