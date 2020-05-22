for (String eachClient : this.clientCatalogue.keySet())
{
    List<Client> clientDetails; = clientCatalogue.get(eachClient);

    for(Client cl : clientDetails)
    {

         System.out.println("Details of client are: " + cl.toString());
    }
}