public void deleteContact(long phonenumber) throws FileNotFoundException{
InputStream is = new FileInputStream(filename);
JsonReader fileReader = Json.createReader(is);
JsonArray contactObj = (JsonArray) Json.createParserFactory(fileReader.readObject());
JsonArrayBuilder factory= Json.createArrayBuilder();

for (int i = 0; i < contactObj.size(); i++) {
  if(contactObj.getJsonObject(i).getInt("Number")!=phoneNumber){
    JsonObjectBuilder nameBuilder = Json.createObjectBuilder();
    JsonArrayBuilder  contactArrayBuilder= Json.createArrayBuilder();

    nameBuilder.add("First Name",contactObj.getJsonObject(i).getJsonObject("Name").getString("First Name"));
    nameBuilder.add("Last Name",contactObj.getJsonObject(i).getJsonObject("Name").getString("Last Name"));

    contactBuilder.add("Name", nameBuilder);
    contactBuilder.add("Type", typeof);
    contactBuilder.add("number", contactObj.getJsonObject(i).getInt("Number"));
    factory.add(contactBuilder)
  }
}
JsonArray res=factory.build();
//write to file
OutputStream os = new FileOutputStream(filename);
JsonWriter fileWriter = Json.createWriter(os);
fileWriter.writeArray(contactArray);
fileWriter.close();}
}