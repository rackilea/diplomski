@XmlRootElement
@XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.PROPERTY)
public class E {

    private EGroup groupDefinition;

    public EGroup getGroupDefinition () {
        return groupDefinition;
    }
    @XmlAttribute
    public void setGroupDefinition (EGroup g) {
        groupDefinition = g;
    }

    public enum EGroup {
        SOME,
        OTHERS,
        THE_REST
    }

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(E.class);

        E eOne = new E();
        eOne.setGroupDefinition(EGroup.SOME);

        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        StringWriter writer = new StringWriter();
        m.marshal(eOne, writer);

        assert writer.toString().equals("<e groupDefinition=\"SOME\"/>");

        E eTwo = (E) jc.createUnmarshaller().unmarshal(new StringReader(writer.toString()));

        assert eOne.getGroupDefinition() == eTwo.getGroupDefinition();
    }
}