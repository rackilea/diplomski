public List<Client> getAllCustomers() throws SQLException {
    List<Client> listOfClients = new ArrayList<Client>();

    String sql = "SELECT * FROM `client`";
    result = statement.executeQuery(sql);

    while (result.next()) {
        Client client = new Client();
        client.setName(result.getString("namee"));
        client.setSurname(result.getString("surname"));
        // ... and so on
        listOfClients.add(client);
    }

    return listOfClients;
}