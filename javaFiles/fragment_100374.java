public class MySoapHandler implements SOAPHandler<SOAPMessageContext>
{
    @Override
    public Set<QName> getHeaders ()
    {
        ...
    }

    @Override
    public boolean handleMessage (final SOAPMessageContext context)
    {
        ...
    }

    @Override
    public boolean handleFault (final SOAPMessageContext context)
    {
        ...
    }

    @Override
    public void close (final MessageContext context)
    {
        ...
    }
}