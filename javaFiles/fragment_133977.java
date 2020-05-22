@GET
@Produces(MediaType.APPLICATION_JSON)
public Map<Object, Object> getList(@QueryParam("empId") String empid) throws Exception {
    System.out.println("id is"+empid);  //when I try to print the empid,it  displays nothing
    Map<Object, Object> map=reportee.getReportees(empid);  
    return map;             
}