//Property to filter the model
Property geoProperty = 
    model. createProperty("http://www.w3.org/2003/01/geo/wgs84_pos#",
                          "geometry");

//Iterator based on a Simple selector
StmtIterator iter =
  model.listStatements(new SimpleSelector(null, geoProperty, (RDFNode)null)); 

//Loop to traverse the statements that match the SimpleSelector
while (iter.hasNext()) {
   Statement stmt = iter.nextStatement();
   System.out.print(stmt.getSubject().toString());
   System.out.print(stmt.getPredicate().toString());
   System.out.println(stmt.getObject().toString());

}