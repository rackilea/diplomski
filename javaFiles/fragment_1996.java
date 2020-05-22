private class InsertXMLDataProcedure extends StoredProcedure {

    public InsertXMLDataProcedure(DataSource ds) {
        super(ds, PROCEDURE_NAME);
        declareParameter(new SqlParameter("COMPANYNO", Types.INTEGER));
        declareParameter(new SqlParameter("XMLDATA", OracleTypes.OPAQUE, "SYS.XMLTYPE"));
        declareParameter(new SqlParameter("ERRORNO", Types.INTEGER));
        declareParameter(new SqlParameter("ERRORDESC", Types.VARCHAR));
        compile();
    }

    public Map<String, Object> execute(int companyNumber, String xmlData, int errorNumber, String errorDescription) {
        return super.execute(companyNumber, new OracleXmlTypeValue(xmlData), errorNumber, errorDescription);
    }
}