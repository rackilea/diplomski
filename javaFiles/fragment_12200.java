@Bean
public StoredProcedureItemReader reader(DataSource dataSource) {
        StoredProcedureItemReader reader = new StoredProcedureItemReader();

        reader.setDataSource(dataSource);
        reader.setProcedureName("sp_customer_credit");
        reader.setRowMapper(new CustomerCreditRowMapper());
        reader.setRefCursorPosition(1);

        return reader;
}