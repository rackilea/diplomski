@GET
@Path("/{format}/{part1}/{part2}/")
Response getCheck(@PathParam("format") String format, @PathParam("part1") String part1, @PathParam("part2") String part2, @QueryParam("") MyBean myBean);

 public class MyBean{
    public void setX(String x) {...}
    public void setY(String y) {...}  
 }