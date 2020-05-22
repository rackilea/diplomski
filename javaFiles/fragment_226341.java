@Path("device")
public class DeviceApi
{
    @PUT
    @Path("{id}")
    public Device deviceAction(..., Device device) {...}
}