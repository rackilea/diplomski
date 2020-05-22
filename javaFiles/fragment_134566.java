@javax.xml.bind.annotation.XmlSchema( 
    namespace = "http://www.example.org", 
    xmlns = {
        @javax.xml.bind.annotation.XmlNs(prefix = "xsd", namespaceURI = "http://www.w3.org/2001/XMLSchema"),
    },
    elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED) 
package example;