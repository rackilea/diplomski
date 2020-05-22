public BigDecimal getRendimentoLordoCertificato(Date currentDate) {

    String sql = "select Coefficiente_12 from CoefficienteRendimento where DataRendimento =  ?";

    List<BigDecimal> rendicontoLordoCert = getJdbcTemplate().query(
            sql, new Object[] { currentDate }, BigDecimal.class);

    if (rendicontoLordoCert.size > 0) {
        return rendicontoLordoCert.get(0);
    }
    return null;
}