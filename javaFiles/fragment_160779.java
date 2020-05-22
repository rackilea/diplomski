public OutputStream getGlasDocument(final Document doc, final OutputStream outStream) {             

    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(rdcJdbcTemplate)
    .withProcedureName(PROC_NAME)
    .withCatalogName(CATALOG_NAME)
    .withSchemaName(SCHEMA_NAME).declareParameters(new SqlParameter(DOC_ID_PARAM, OracleTypes.VARCHAR),
            new SqlOutParameter(OUT_PARAM, OracleTypes.BLOB, null, new SqlReturnType() {

                @Override
                public Object getTypeValue(CallableStatement cs, int paramIndex,
                        int sqlType, String typeName) throws SQLException {
                    try {
                        Blob blob = cs.getBlob(1);
                        if (blob != null){
                            FileCopyUtils.copy(cs.getBlob(1).getBinaryStream(), outStream);
                        }                           
                    } catch (IOException e) {                           
                        logger.debug(e.getMessage());
                    }
                    return null;
                }
            }));

    SqlParameterSource in = new MapSqlParameterSource().addValue(DOC_ID_PARAM, doc.getId());        
    simpleJdbcCall.execute(in);
    return outStream;
}