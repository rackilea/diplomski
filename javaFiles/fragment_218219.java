SOAPHeader header = msgContext.getEnvelope().getHeader();
if( header != null )
{
    Iterator<?> blocks = soapHeader.examineAllHeaderBlocks();
    while( blocks.hasNext() )
    {
        SOAPHeaderBlock block = (SOAPHeaderBlock)blocks.next();
        if( ... some check to see if this is one of your headers ... )
            block.setProcessed();
    }
}