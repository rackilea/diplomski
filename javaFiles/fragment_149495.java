@XmlRootElement
class Root {

    @XmlElementWrapper(name = "wrapper")
    @XmlElement
    private List<Element> element;

    void beforeMarshal(Marshaller u) {
        if (element != null && element.isEmpty()) {
            element = null;
        }
    }
}

class Element {

}

public static void main(String[] args) throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(Root.class);
    StringWriter writer = new StringWriter();
    Root jaxbElement = new Root();
    jaxbElement.element = new ArrayList<JaxbNullElementWrapper.Element>();
    context.createMarshaller().marshal(jaxbElement, writer);
    System.out.println(writer.toString());
}