package org.example.schema;

import java.math.BigDecimal;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"bar"})
@XmlRootElement(name = "foo")
public class Foo {

    @XmlElement(required = true)
    protected BigDecimal bar;

    ...

}