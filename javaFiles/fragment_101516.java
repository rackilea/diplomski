package com.massaiolir.simple.iface;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class ResC extends BaseObject {
    @Element(name = "ConRes")
    public ConRes conRes;
}