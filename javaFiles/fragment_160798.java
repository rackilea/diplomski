enum BaseType {
    PROGRAM(new Program()),
    ANOTHER(new Another());
    private BaseDAO baseDAO;
    BaseType (BaseDAO baseDAO) {
        this.baseDAO = baseDAO;
    }
    public BaseDAO getBaseDAO() {
        return baseDAO;
    }
}

public static ResultSet getDataFor(BaseType type) throws SQLException {
    Statement statement = con.createStatement();
    return statement.executeQuery(type.getBaseDAO().getSelectAllQuery());
}