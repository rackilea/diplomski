class ClientMapper implements SqlMapper<Client> {
    @Override
    public Client map(ResultSet rs) throws SQLException {
       Client client = new Client();
       client.setId(rs.getInt("Id"));
       client.setName(rs.getString("Name"));
       client.setLastName(rs.getString("LastName"));
       client.setAddress(rs.getString("Address"));
       return client;
    }
}