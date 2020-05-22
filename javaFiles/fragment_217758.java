@POST
@Consumes("application/xml")
@Produces("text/plain")
public String registerPost(MyEntityClass payload) {

 try {
     //update DB
     myService.save(payload);
     return "success";
 } catch (DatabaseException e) {
     return "Fail";
 }

}