@Path("device")
public class DeviceApi
{
    @PUT
    @Path("{id: ^(jobs)}")
    public Device deviceAction(..., Device device) {...}
}