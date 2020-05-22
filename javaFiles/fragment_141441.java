@javax.xml.bind.annotation.XmlSchema(namespace = "yournamespace", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED,
xmlns = {
    @XmlNs(prefix="asd", namespaceURI="yournamespace"),
})


package example;

import javax.xml.bind.annotation.XmlNs;