List<String> data1 = new ArrayList<String>(Arrays.asList(samp.replace("[","").replace("]","").split(",")));

for (String name : data1) {
  names += name;   // This lines concatenate the name.
 //If you want to insert single name the you can directly insert the name value into databas.  
  String query = "INSERT INTO AUTOINC(PersonName)"+"VALUES('"+name+"')";
  PreparedStatement preparedStatement =   con.prepareStatement(query);
  preparedStatement.executeUpdate();
}