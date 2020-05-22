import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

public class HeaderAdder {

    public static void addSecurityToHeader(
            org.apache.axiom.soap.SOAPHeader header) {

        OMFactory factory = OMAbstractFactory.getOMFactory();

        OMNamespace namespaceWSSE = factory
                .createOMNamespace(
                        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                        "wsse");

        OMElement element = factory.createOMElement("Security", namespaceWSSE);

        OMAttribute attribute = factory.createOMAttribute("mustUnderstand",
                null, "1");

        element.addAttribute(attribute);

        header.addChild(element);

        OMElement element2 = factory.createOMElement("UsernameToken",
                namespaceWSSE);

        OMNamespace namespaceWSU = factory
                .createOMNamespace(
                        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd",
                        "wsu");

        attribute = factory.createOMAttribute("Id", namespaceWSU,
                "UsernameToken-1");

        element2.addAttribute(attribute);

        element.addChild(element2);

        OMElement element3 = factory.createOMElement("Username", namespaceWSSE);

        element3.setText("<YOUR USERNAME>");

        OMElement element4 = factory.createOMElement("Password", namespaceWSSE);

        attribute = factory
                .createOMAttribute(
                        "Type",
                        null,
                        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");

        element4.setText("<YOUR PASSWORD>");

        element2.addChild(element3);
        element2.addChild(element4);
    }
}