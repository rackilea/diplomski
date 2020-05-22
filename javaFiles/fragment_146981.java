@Root
@Convert(Example.ExampleConverter.class)
public class Example
{
    private Map<String, String> map;

    // ...

    static class ExampleConverter implements Converter<Example>
    {
        @Override
        public Example read(InputNode node) throws Exception
        {
            Example value = new Example();
            value.map = new HashMap<>();

            InputNode childNode = node.getNext();

            while( childNode != null )
            {
                value.map.put(childNode.getName(), childNode.getValue());
                childNode = node.getNext();
            }

            return value;
        }

        @Override
        public void write(OutputNode node, Example value) throws Exception
        {
            for( Entry<String, String> entry : value.map.entrySet() )
            {
                node.getChild(entry.getKey()).setValue(entry.getValue());
            }
        }
    }
}