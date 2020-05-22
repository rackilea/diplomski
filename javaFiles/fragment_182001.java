public void loadPage(String permission)
{
    // permission can be any type. This is just an example.
    XmlReturn xml = XmlFactory.getInstance(permission);
    xml.displayXML();
    // This method exists in all objects that implement XmlReturn
}