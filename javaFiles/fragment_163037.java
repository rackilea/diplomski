@GET
@Path("shutdown")
@Produces(MediaType.TEXT_PLAIN)
public String shutdown(){
    new Thread(new ShutDown()).start();                 
    return "Down";
}