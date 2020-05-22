@Override 
public Component getHeader(final String componentId)
{
    Component header = super.getHeader(componentId);
    header.add(AttributeModifier.replace("class", "myCssClass"));
    return header;
}