@Path("/{test}")
@POST
// Javax.ws.rs.PathParam
public String addValue(@PathParam("test") final String test) throws 
// SpringFramework
//public String addValue(@PathVariable("test") final String test) throws IOException {
    final String value = test;
    CSVWriter writer = new CSVWriter(new FileWriter(value, true), ',');
    String[] entries = valueString.split(",");
    writer.writeNext(entries);
    writer.close();
    return "ok";  
}