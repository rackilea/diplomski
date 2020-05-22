public class XMLEventsConverter implements Converter<XMLEvents> {

    private Serializer serializer;

    XMLEventsConverter(Serializer serializer){
        this.serializer = serializer;
    }

    @Override
    public XMLEvents read(InputNode arg0) throws Exception {
        return null;
    }

    @Override
    public void write(OutputNode node, XMLEvents xmlEvents) throws Exception {
        for (XMLEvent event : xmlEvents.events) {
            serializer.write(event, node);
        }
    }

}