public class WorldObjectConverter implements Converter<WorldObject>
{
    @Override
    public WorldObject read(InputNode node) throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void write(OutputNode node, WorldObject value) throws Exception
    {
        final Field f = value.getClass().getDeclaredField("vectorNames"); // get the field 'vectorNames' of the 'WorldObject' class
        final Element elementAnnotation = f.getAnnotation(Element.class); // get the 'Element' annotation of the Field

        final String name = elementAnnotation.name(); // get the 'name'-value of the annotation
        node.setName(name); // set Nodename


        for( List<String> list : value.getVectorNames() )
        {
            OutputNode subList = node.getChild("list-string");

            for( String str : list )
            {
                OutputNode stringNode = subList.getChild("string");
                stringNode.setValue(str);
            }

            subList.commit();
        }

        node.commit();
    }
}