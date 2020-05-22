@Path("/list")
@Produces({ "application/json" })
public List<LeaveBalance> list() {
    List l= new LeaveDao().getAllLeaves();
    return l;
}