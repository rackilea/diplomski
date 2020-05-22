public class OptionsParser extends DefaultHandler {
    private final StringBuilder valueBuffer = new StringBuilder();
    private final Map<String, Option> resultAsMap = new HashMap<String, Option>();
    private final List<Option> options = new ArrayList<Option>();

    //variable to store the values from xml temporarily
    private Option temp;

    public List<Option> getOptions() {
        return options;
    }

    public Map<String, Option> getResultAsMap() {
        return resultAsMap;
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName,
            final Attributes attributes) throws SAXException {
        if("option".equalsIgnoreCase(qName)) {
            temp = new Option();
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName)
            throws SAXException {
        //read the value into a string to set them to option object
        final String value = valueBuffer.toString().trim();
        switch (qName) {
        case "name":
            temp.setName(value);
            // set the value into map and name of the option is the key
            resultAsMap.put(value, temp);
            break;
        case "type":
            temp.setType(value);
            break;
        case "value":
            temp.setValue(value);
            break;
        case "constant":
            temp.setConstant(value);
            break;
        case "option":
            // this is the end of option tag add it to the list
            options.add(temp);
            temp = null;
            break;
        default:
            break;
        }
        //reset the buffer after every iteration
        valueBuffer.setLength(0);
    }

    @Override
    public void characters(final char[] ch, final int start, final int length)
            throws SAXException {
        //read the value into a buffer
        valueBuffer.append(ch, start, length);
    }
}