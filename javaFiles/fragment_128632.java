> method = RequestMethod.POST
> 
> @Path("/connections") @Consumes({ MediaType.APPLICATION_JSON_VALUE })
> @Produces({ MediaType.APPLICATION_JSON_VALUE }) public interface
> EmployeeService{ 
> @POST     
> Response getEmployeeDetails(String body);