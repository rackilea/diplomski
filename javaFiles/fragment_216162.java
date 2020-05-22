SimpleJdbcCall insertParcelas = new SimpleJdbcCall(jdbcTemplate)
        .withSchemaName("dbo")
        .withCatalogName("dbo")     
        .withProcedureName("AD_INSERT_ADIANTAMENTO_PARCELAS")
        .declareParameters(             
                new SqlParameter("DATAVCM", OracleTypes.DATE),
                new SqlParameter("VALOR", OracleTypes.VARCHAR),
                ....
                new SqlOutParameter("DUPLIC", OracleTypes.NUMBER));

DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
SqlParameterSource in = new MapSqlParameterSource()
    .addValue("DATAVCM", new java.sql.Date(fmt.parse(arquivo.getVencimento()).getTime()))
    .addValue("VALOR", arquivo.getValor())
    .addValue("MOTIVO", arquivo.getCodMotivo())
    .addValue("EMPRESA", arquivo.getCodEmpresa())
    .addValue("NPARCELA", 1)
    .addValue("TOTALPARCELA", 1)
    .addValue("DOCUMENTO", arquivo.getDocumento())
    .addValue("FUNCIONARIO", arquivo.getCodFunc())
    .addValue("HISTORICO", "VALE IMPORTADO")
    .addValue("EXPORTAR", 0)
    .addValue("USUARIO", usuario.getCodigousuario())
    .addValue("DUPLIC", 0)
    .addValue("PROTOCOLO", "0");

Map<String, Object> out = insertParcelas.execute(in);

if (out != null && !out.isEmpty()) {
    Sysout.out.println(out.getInt("DUPLIC"));
}