package com.example._default;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "address"
})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlAnyElement
    protected Element address;

    public Element getAddress() {
        return address;
    }

    public void setAddress(Element value) {
        this.address = value;
    }

}