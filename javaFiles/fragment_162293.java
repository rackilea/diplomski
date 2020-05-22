OMNode child = omElement.getFirstOMChild();
while ( child != null )
{
    if ( child instanceof OMText )
    {
        // process 'child' text here

        final OMNode nextSibling = child.getNextOMSibling();
        child.detach();    // detach from OM to keep memory usage low
        child = nextSibling;
    }
}