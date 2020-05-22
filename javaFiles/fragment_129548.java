public ArrayList<Client> getAllClients(List<Client> outputList, List<Client> list) {
    for (Client client : list) {
        if (!outputList.contains(client)) {
            getAllClients(outputList, client.getLinked());
            outputList.add(client);
        }
    }
    return outputList;
}