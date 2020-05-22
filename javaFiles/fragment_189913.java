package com.org.test1;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterDATA extends XmlAdapter<String, String> {

@Override
public String marshal(String arg0) throws Exception {
    return arg0;
}
@Override
public String unmarshal(String arg0) throws Exception {
    return arg0;
}

}