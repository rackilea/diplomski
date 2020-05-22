public class Main {
public static void main(String... args) {
    String response = "<RESPONSE><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<ID>\n" +
            "  <EMAIL>xxx@yyy</EMAIL>\n" +
            "  <EMAIL>klihf@kjf</EMAIL>\n" +
            "  <EMAIL>ddd@fff</EMAIL>\n" +
            "  <EMAIL>@ddd</EMAIL>\n" +
            "  </ID>\n" +
            " ]]></RESPONSE>";
    String xml = response.substring(response.indexOf("<ID>"), response.lastIndexOf("]]>"));
    Id id = null;
    try {
        JAXBContext jc = JAXBContext.newInstance(Id.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource streamSource = new StreamSource(new StringReader(xml));
        JAXBElement<Id> element = unmarshaller.unmarshal(streamSource, Id.class);
        id = element.getValue();
    } catch (JAXBException ex) {
        ex.printStackTrace();
    }

    System.out.println(id.getEMAIL().size());
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "email"
})
@XmlRootElement(name = "ID")
public static class Id {

    @XmlElement(name = "EMAIL")
    private List<String> email;

    public List<String> getEMAIL() {
        if (email == null) {
            email = new ArrayList<>();
        }
        return this.email;
    }
}