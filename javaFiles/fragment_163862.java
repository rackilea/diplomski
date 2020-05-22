public Client clone(){
      Client client = new Client();
      client.name=name; 
      client.id=id;
      ...

      // copy each element property;

      return client;

 }