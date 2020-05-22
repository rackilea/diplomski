for (Person person : people) {
  if (person instanceof Client) {
    Client client = (Client) person;
    if (client.clientID == cid) {
      System.out.println("found!");
    }
  }
}