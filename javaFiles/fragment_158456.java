public Result jsonAlias(Long parameterID) 
{

JsonNode json = request().body().asJson();
ObjectMapper objectMapper = new ObjectMapper();


try {

List<Alias> list = objectMapper.readValue(json.toString(),TypeFactory.defaultInstance().constructCollectionType(List.class, Alias.class));

    for(Alias x : list)
    {

      //Update
      if(x.id != null)
      {                    
      Alias a = Alias.find.byId(x.id);
      a.name = x.name;
      a.parameters = Parameters.find.byId(parameterID);
      a.update();
      }

      //Insert
      else
      {
      Alias a = new Alias();
      a.id = null;
      a.name = x.name;
      a.parameters = Parameters.find.byId(parameterID);
      a.save();
      }  

    }

} catch (IOException e) {e.printStackTrace();}


return GO_HOME;
}