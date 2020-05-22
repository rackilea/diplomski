package com.abc.TryXmltoJava;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Vectors")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vectors {

    @XmlElement(name="Vector")
    List<Vector> vector;

}