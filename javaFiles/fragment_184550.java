@DELETE
@Path("/{url : .+}")
public void deleteUrl(@HeaderParam("request-origin") String origin, 
        @PathParam("url") String url){
    // some stuff
}