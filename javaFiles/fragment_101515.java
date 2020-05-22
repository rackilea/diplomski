package com.massaiolir.simple.iface;

import org.simpleframework.xml.Element;

public class ConRes extends BaseObject {
    @Element(name = "ConList")
    public ConList conList;
}