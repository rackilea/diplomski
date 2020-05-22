@XmlSchema(namespace = "http://Foo/bar",
           elementFormDefault = XmlNsForm.QUALIFIED,
           xmlns = @XmlNs(prefix = "", namespaceURI = "http://Foo/bar"))
package com.mycompany.mypackage;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;