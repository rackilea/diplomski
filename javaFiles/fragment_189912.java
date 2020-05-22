/**
JMathur
*/

package com.org.test1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Column {
@XmlValue
@XmlJavaTypeAdapter(AdapterDATA.class)
protected String value;

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}

@XmlAttribute
protected String name;


public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}


}