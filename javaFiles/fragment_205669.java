public class SomeDaoImpl extends JdbcTemplate implements SomeDao {
    private static final String NAME_BY_ACCOUNT = 
                                "SELECT NAME FROM CLIENTS WHERE ACCOUNT = ?"

    public List<Map<String, Object>> getUsernameByAccount(String account) {
        return (List<Map<String, Object>>) queryForList(
                                           NAME_BY_ACCOUNT,
                                           new Object[] { account },
                                           new int[] { Types.VARCHAR });
    }
}