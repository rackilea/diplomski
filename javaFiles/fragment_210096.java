public void findDuplicatedNumbers() {
    Map<String, Set<Client> > duplicates = 
       new HashMap<String, Set<Client> >();
    Set<String> phoneNumbers = new HashSet<String>();

    for(Client client : clientList) {
         PhoneBook phoneBook = client.getPhoneBook();
         phoneNumbers.addAll(phoneBook.getNumberList());
    }

    for(String phoneNumber : phoneNumbers) {
       Set<Client> clients = findClientsByPhoneNumber(phoneNumber);

       if(clients.size() > 1)
           duplicates.put(phoneNumber, clients);
    }

    for(Entry<String, Set<Client> entry : duplicates.entrySet()) {

          System.out.println("phonenumber " +  entry.getKey() + " is dubplicated / is share with these clients:");
          for(Client client : entry.getValue()) {
             System.out.println(client.getName());
          }

    }
}
protected Set<Client> findClientsByPhoneNumber(String phoneNumber) {
    Set<Client> clients = new HashSet<Client>();

    for(Client client : clientList ) {
       List<String> phoneNumbers = client.getPhonebook().getNumberList();
       if(phoneNumbers.contains(phoneNumber)) {
          clients.add(client);
       }
    }
    return clients;
}