public static <U> XMLParser<U> getInstance()
{
    if(reference==null)
        reference = new XMLParser<U>();
    return (XMLParser<U>)reference;
}