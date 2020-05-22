WebResource resource = client.resource(url); 
Builder builder = resource.accept(MediaType.APPLICATION_JSON); 
GenericType<List<EMailInformations>> genericType = 
  new GenericType<List<EMailInformations>>() {};

List<EMailInformations> response = builder.get(genericType);