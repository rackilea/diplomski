@Override
public Map<String, String> map(int index, ResultSet r, StatementContext ctx) throws SQLException {
    Map<String, String> configs = new HashMap<String, String>();
    configs.put(r.getString("configKey"), r.getString("configValue"));
    return configs;
}