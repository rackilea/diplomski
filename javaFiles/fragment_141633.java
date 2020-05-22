@XmlSchema(
    elementFormDefault=XmlNsForm.QUALIFIED,
    namespace="http://www.example.com/FOO",
    xmlns={
        @XmlNs(prefix="", namespaceURI="http://www.example.com/FOO")
        @XmlNs(prefix="bar", namespaceURI="http://www.example.com/BAR")
    }
)
package blog.prefix;

import javax.xml.bind.annotation.*;