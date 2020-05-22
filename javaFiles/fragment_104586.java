class CustomerItemSqlParameterSourceProvider implements ItemSqlParameterSourceProvider<Customer> {

    @Override
    public SqlParameterSource createSqlParameterSource(Customer customer) {
        Map<String, Object> params = new HashMap<>();
        params.put("custNum", customer.getCust_Num());
        params.put("nameSurname", customer.getName_Surname());
        return new MapSqlParameterSource(params);
    }
}