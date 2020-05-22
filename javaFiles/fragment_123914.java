private static List<Client> mapClients(List<Client> clients, DoubleUnaryOperator op) {
    for (Client client : clients) {
        client.setBuys(op.applyAsDouble(client.getBuys()))
    }
    return clients;
}