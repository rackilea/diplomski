public class DSLOrder {

    private final static String XML_BEFORE="<DslOrder index=\"1422796670990\">\n" + 
            "<orderId index=\"1422796671001\">123456</orderId>\n" + 
            "<AsdlServiceDetails index=\"1422796670991\">\n" + 
            "<bandwidth index=\"1422796670993\">45678</bandwidth>\n" + 
            "</AsdlServiceDetails>\n" + 
            "<SubscriberInfo index=\"1422796670994\">\n" + 
            "<Address index=\"1422796670996\">\n" + 
            "<City index=\"1422796670999\">MO</City>\n" + 
            "<PostalCode index=\"1422796670998\">456</PostalCode>\n" + 
            "<Street index=\"1422796670997\">sdfghh</Street>\n" + 
            "</Address>\n" + 
            "<PhoneNumber index=\"1422796671000\">45678</PhoneNumber>\n" + 
            "<Name index=\"1422796670995\">sedrtfgh</Name>\n" + 
            "</SubscriberInfo>\n" + 
            "</DslOrder>";


    public interface Projection {
        // Define any methods for manipulation here       
        @XBUpdate("/DslOrder/SubscriberInfo/PhoneNumber")
        void updatePhoneNumber(String newNumber);

        // Define any methods for manipulation here       
        @XBUpdate("/DslOrder/SubscriberInfo/Name")
        void updateName(String newName);

        @XBWrite("/DslOrder/SubscriberInfo/additionalTag")
        void createAdditionalTag(String value);
    }

    public static void main(String[] args) {
        Projection projection = new XBProjector(Flags.TO_STRING_RENDERS_XML).onXMLString(XML_BEFORE).createProjection(Projection.class);
        projection.updatePhoneNumber("12345");
        projection.updateName("New Name");
        projection.createAdditionalTag("value for new tag");
        System.out.println(projection.toString());
    }
}