public class SpringQueryParser {
    Connection con; 
    public SpringQueryParser(Connection con) {
        this.con = con;
    }
    public String getFinalQuery(String query, SqlParameterSource source) throws SQLException {
        ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(query);
        String finalQuery = new PreparedStatementCreatorFactory(NamedParameterUtils.substituteNamedParameters(parsedSql,
                source), NamedParameterUtils.buildSqlTypeArray(parsedSql, source))
                .newPreparedStatementCreator(NamedParameterUtils.buildValueArray(parsedSql, source, null))
                .createPreparedStatement(con).toString();
         return finalQuery.substring(finalQuery.indexOf(":") + 1, finalQuery.length()).trim();
    }
}