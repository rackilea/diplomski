@Suspend( contentType = MediaType.APPLICATION_JSON, period = MAX_SUSPEND_MSEC )
@GET
public Broadcastable suspend( @Context final BroadcasterFactory factory )
{
    return new Broadcastable( factory.lookup( MY_CHANNEL, true ) );
}