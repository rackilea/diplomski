for (List<Client> clientDetails : this.clientCatalogue.values())
{
    for(Client cl : clientDetails)
    {    
         System.out.println("Details of client are: " + cl.toString());
    }
}