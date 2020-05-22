@XmlRootElement
public class Demo {
    // Should be same same as key (or we need annotations)
    private String value;
    public String getValue() { return value; }
    public void setValue(String value) {this.value = value;}
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response postJson(Demo demo) {
    System.out.println(demo.getValue());
    return Response.created(newUri).build();
}