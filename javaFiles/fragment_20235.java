@XmlSchema(xmlns = @XmlNs(prefix = "tns", namespaceURI = "http://test.com"),
           namespace = "http://test.com",
           elementFormDefault = XmlNsForm.QUALIFIED,
           attributeFormDefault = XmlNsForm.QUALIFIED)
package test;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;