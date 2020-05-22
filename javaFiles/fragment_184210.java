public class ChildConverter implements Converter<Child>
{
    @Override
    public Child read(InputNode node) throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public void write(OutputNode node, Child value) throws Exception
    {
        if( value.isActived() == true ) // Check if 'activated' flag is set
        {
            // Set valus of the child
            node.setValue(value.getValue());
            node.setAttribute("secondValue", String.valueOf(value.getSecondValue()));
        }
        else
        {
            node.remove(); // Remove the node since we don't need it
        }
    }

}