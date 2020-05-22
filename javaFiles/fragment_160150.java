@Path("resources")
class MyResource {
   var subs = Map[String, AnyRef]()

   @GET
   def get = ...

   @Path("{sub}") 
   def sub(@QueryParam("sub") sub: String) = subs(sub)
}