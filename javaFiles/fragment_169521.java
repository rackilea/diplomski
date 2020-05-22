public interface ConnectionVisitor {

    public int visit (Connection connection);
    public int visit (SqlServerConnection sqlconnection);
    public int visit (OracleConnection oracleConnection)
}