@GET
@Path("xml")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({  MediaType.APPLICATION_XML })
public String GetXMl(){
    StringBuffer sb = new StringBuffer("<tv name=\"sony\"></tv>");
    String xml =sb.toString();
    return xml;
}